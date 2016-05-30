/**
 * This file is part of Cetus.
 *
 * Cetus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cetus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Cetus.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.aksw.simba.cetus.annotator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.gerbil.transfer.nif.data.TypedNamedEntity;
import org.aksw.gerbil.utils.filter.MarkingFilter;
import org.aksw.gerbil.utils.filter.TypeBasedMarkingFilter;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;
import org.aksw.simba.cetus.yago.YagoBasedTypeSearcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDFS;

//@Ignore
@RunWith(Parameterized.class)
public class ExtendedYagoBasedTypeSearcherTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtendedYagoBasedTypeSearcherTest.class);

    private static final String DOLCE_NAMESPACE = "http://www.ontologydesignpatterns.org/ont/";
    private static final String WRONG_NAMESPACE1 = "http://ontologydesignpatterns.org/ont/";
    private static final String WRONG_NAMESPACE2 = "http://www.ontologydesignpatterns.org/ont/wikipedia/";
    private static final String WRONG_NAMESPACE3 = "http://ontologydesignpatterns.org/ont/wikipedia/";

    private static final String BLACKLISTED_LOCATION_URI = "http://www.ontologydesignpatterns.org/ont/dul/DUL.owl#Location";
    private static final String CORRECT_LOCATION_URI = "http://www.ontologydesignpatterns.org/ont/d0.owl#Location";

    @Parameters
    public static Collection<Object[]> data() {
        List<Document> documents = ExtendedCetusSurfaceFormExtractorTest.loadDataset();
        List<Object[]> testConfigs = new ArrayList<Object[]>();
        for (Document document : documents) {
            testConfigs.add(new Object[] { document, extractNamedEntity(document), extractMarkings(document),
                    extractExpectedTypes(document) });
        }
        return testConfigs;
    }

    private static final CetusTypeSearcher SEARCHER = YagoBasedTypeSearcher.create();

    public Document nifDocument;
    public NamedEntity namedEntity;
    public List<ExtendedTypedNamedEntity> surfaceForms;
    public Set<String> expectedTypes;

    public ExtendedYagoBasedTypeSearcherTest(Document nifDocument, NamedEntity namedEntity,
            List<ExtendedTypedNamedEntity> surfaceForms, Set<String> expectedTypes) {
        this.nifDocument = nifDocument;
        this.namedEntity = namedEntity;
        this.surfaceForms = surfaceForms;
        this.expectedTypes = expectedTypes;
    }

    @Test
    public void test() {
        LOGGER.info("Starting test for \"" + nifDocument.getDocumentURI() + "\".");
        TypedNamedEntity tne = SEARCHER.getAllTypes(nifDocument, namedEntity, surfaceForms);
        // boolean successful = true;
        StringBuilder errorMsg = new StringBuilder();
        for (String type : tne.getTypes()) {
            if (type.startsWith(DOLCE_NAMESPACE) || type.startsWith(WRONG_NAMESPACE1)) {
                if (expectedTypes.contains(type)) {
                    expectedTypes.remove(type);
                } else {
                    errorMsg.append("Couldn't find \"");
                    errorMsg.append(type);
                    errorMsg.append("\" in the list of expected types (");
                    errorMsg.append(expectedTypes.toString());
                    errorMsg.append("), document=\"");
                    errorMsg.append(nifDocument.getDocumentURI());
                    errorMsg.append("\".");
                    LOGGER.warn("Couldn't find \"" + type + "\" in the list of expected types ("
                            + expectedTypes.toString() + "), document=\"" + nifDocument.getDocumentURI() + "\".");
                    // successful = false;
                }
            }
        }
        if (expectedTypes.size() != 0) {
            errorMsg.append("Couldn't find expected types \"");
            errorMsg.append(Arrays.toString(expectedTypes.toArray()));
            errorMsg.append("), document=\"");
            errorMsg.append(nifDocument.getDocumentURI());
            errorMsg.append("\".");
            LOGGER.warn("Couldn't find expected types \"" + Arrays.toString(expectedTypes.toArray()) + "), document=\""
                    + nifDocument.getDocumentURI() + "\".");
            // successful = false;
        }
        // Assert.assertTrue(successful);
        Assert.assertEquals(errorMsg.toString(), 0, errorMsg.length());
    }

    public static Set<String> extractExpectedTypes(Document document) {
        MarkingFilter<TypedNamedEntity> filter = new TypeBasedMarkingFilter<TypedNamedEntity>(false,
                RDFS.Class.getURI(), OWL.Class.getURI());
        List<TypedNamedEntity> namedEntities = document.getMarkings(TypedNamedEntity.class);
        Set<String> types = new HashSet<String>();
        for (TypedNamedEntity tne : namedEntities) {
            if (filter.isMarkingGood(tne)) {
                for (String type : tne.getTypes()) {
                    if (type.startsWith(WRONG_NAMESPACE2)) {
                        types.add(DOLCE_NAMESPACE + type.substring(WRONG_NAMESPACE2.length()));
                    } else if (type.startsWith(WRONG_NAMESPACE3)) {
                        types.add(DOLCE_NAMESPACE + type.substring(WRONG_NAMESPACE3.length()));
                    } else if (type.startsWith(WRONG_NAMESPACE1)) {
                        types.add(DOLCE_NAMESPACE + type.substring(WRONG_NAMESPACE1.length()));
                    } else if (type.startsWith(DOLCE_NAMESPACE)) {
                        types.add(type);
                    }
                }
            }
        }
        if (types.contains(BLACKLISTED_LOCATION_URI)) {
            types.remove(BLACKLISTED_LOCATION_URI);
            types.add(CORRECT_LOCATION_URI);
        }
        if (types.size() == 0) {
            throw new IllegalStateException("Couldn't find an expected type in document " + document.getDocumentURI());
        }
        return types;
    }

    public static NamedEntity extractNamedEntity(Document document) {
        MarkingFilter<TypedNamedEntity> filter = new TypeBasedMarkingFilter<TypedNamedEntity>(false,
                RDFS.Class.getURI(), OWL.Class.getURI());
        List<TypedNamedEntity> namedEntities = document.getMarkings(TypedNamedEntity.class);
        for (TypedNamedEntity tne : namedEntities) {
            if (filter.isMarkingGood(tne)) {
                return new NamedEntity(tne.getStartPosition(), tne.getLength(), tne.getUris());
            }
        }
        return null;
    }

    public static List<ExtendedTypedNamedEntity> extractMarkings(Document document) {
        MarkingFilter<TypedNamedEntity> filter = new TypeBasedMarkingFilter<TypedNamedEntity>(true, RDFS.Class.getURI(),
                OWL.Class.getURI());
        List<TypedNamedEntity> namedEntities = document.getMarkings(TypedNamedEntity.class);
        List<ExtendedTypedNamedEntity> extendedMarkings = new ArrayList<ExtendedTypedNamedEntity>();
        int start, length, end;
        for (TypedNamedEntity tne : namedEntities) {
            if (filter.isMarkingGood(tne)) {
                start = tne.getStartPosition();
                length = tne.getLength();
                end = start + length;
                extendedMarkings.add(new ExtendedTypedNamedEntity(start, length, tne.getUris(), new HashSet<String>(),
                        document.getText().substring(start, end)));
            }
        }
        return extendedMarkings;
    }
}
