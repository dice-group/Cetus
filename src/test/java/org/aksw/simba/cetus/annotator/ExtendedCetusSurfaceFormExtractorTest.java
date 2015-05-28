package org.aksw.simba.cetus.annotator;

import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aksw.gerbil.io.nif.AbstractNIFParser;
import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.Marking;
import org.aksw.gerbil.transfer.nif.data.DocumentImpl;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.gerbil.transfer.nif.data.TypedNamedEntity;
import org.aksw.gerbil.utils.filter.MarkingFilter;
import org.aksw.gerbil.utils.filter.TypeBasedMarkingFilter;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;
import org.apache.commons.io.IOUtils;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.adapters.RDFReaderRIOT;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDFS;

@RunWith(Parameterized.class)
public class ExtendedCetusSurfaceFormExtractorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtendedCetusSurfaceFormExtractorTest.class);

    private static final String DATASET_NAME = "dataset_task_2.ttl";

    @Parameters
    public static Collection<Object[]> data() {
        List<Document> documents = loadDataset();
        List<Object[]> testConfigs = new ArrayList<Object[]>();
        for (Document document : documents) {
            testConfigs.add(new Object[] { reduceToTextAndEntities(document), extractExpectedMarkings(document) });
        }
        return testConfigs;
    }

    private static final CetusSurfaceFormExtractor EXTRACTOR = CetusSurfaceFormExtractor.create();

    public Document nifDocument;
    public Set<TypedNamedEntity> expectedTypes;

    public ExtendedCetusSurfaceFormExtractorTest(Document nifDocument, Set<TypedNamedEntity> expectedTypes) {
        this.nifDocument = nifDocument;
        this.expectedTypes = expectedTypes;
    }

    @Test
    public void test() {
        Map<NamedEntity, List<ExtendedTypedNamedEntity>> result = EXTRACTOR.extractTypeSurfaceForms(nifDocument);
        List<ExtendedTypedNamedEntity> resultTypes;
        ExtendedTypedNamedEntity matchingEntity;
        int expectedStartPos, expectedEndPos, startPos, endPos;
        for (NamedEntity ne : nifDocument.getMarkings(NamedEntity.class)) {
            Assert.assertTrue(result.containsKey(ne));
            resultTypes = result.get(ne);
            for (TypedNamedEntity expectedType : expectedTypes) {
                matchingEntity = null;
                expectedStartPos = expectedType.getStartPosition();
                expectedEndPos = expectedStartPos + expectedType.getLength();
                // search for a matching entity
                for (ExtendedTypedNamedEntity type : resultTypes) {
                    startPos = type.getStartPosition();
                    endPos = startPos + type.getLength();
                    if ((expectedStartPos >= startPos) && (expectedEndPos <= endPos)) {
                        matchingEntity = type;
                    }
                }
                Assert.assertNotNull("Couldn't find " + expectedType + " inside the list of expected types.",
                        matchingEntity);
            }
//            if (resultTypes.size() > 0) {
//                LOGGER.warn("Got more types than expected: " + Arrays.toString(resultTypes.toArray()));
//            }
        }
    }

    public static List<Document> loadDataset() {
        Model nifModel = ModelFactory.createDefaultModel();
        InputStream inputStream = ExtendedCetusSurfaceFormExtractorTest.class.getClassLoader().getResourceAsStream(
                DATASET_NAME);
        if (inputStream == null) {
            LOGGER.error("Couldn't get InputStream for the dataset. Returning null");
            return null;
        }
        try {
            LocalNIFParser parser = new LocalNIFParser(Lang.TTL);
            return parser.parseNIF(inputStream, nifModel);
        } catch (Exception e) {
            LOGGER.error("Exception while parsing dataset. Returning null", e);
            return null;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static Document reduceToTextAndEntities(Document document) {
        MarkingFilter<TypedNamedEntity> filter = new TypeBasedMarkingFilter<TypedNamedEntity>(false,
                RDFS.Class.getURI(), OWL.Class.getURI());
        List<TypedNamedEntity> namedEntities = document.getMarkings(TypedNamedEntity.class);
        List<Marking> markings = new ArrayList<Marking>(namedEntities.size());
        for (TypedNamedEntity tne : namedEntities) {
            if (filter.isMarkingGood(tne)) {
                markings.add(new NamedEntity(tne.getStartPosition(), tne.getLength(), tne.getUris()));
            }
        }
        return new DocumentImpl(document.getText(), document.getDocumentURI(), markings);
    }

    public static Set<TypedNamedEntity> extractExpectedMarkings(Document document) {
        MarkingFilter<TypedNamedEntity> filter = new TypeBasedMarkingFilter<TypedNamedEntity>(true,
                RDFS.Class.getURI(), OWL.Class.getURI());
        return new HashSet<TypedNamedEntity>(filter.filterList(document.getMarkings(TypedNamedEntity.class)));
    }

    protected static class LocalNIFParser extends AbstractNIFParser {

        private Lang language;

        public LocalNIFParser(Lang language) {
            super("");
            this.language = language;
        }

        @Override
        protected Model parseNIFModel(InputStream is, Model nifModel) {
            RDFReaderRIOT rdfReader = new RDFReaderRIOT(language);
            rdfReader.read(nifModel, is, null);
            return nifModel;
        }

        @Override
        protected Model parseNIFModel(Reader reader, Model nifModel) {
            RDFReaderRIOT rdfReader = new RDFReaderRIOT(language);
            rdfReader.read(nifModel, reader, "");
            return nifModel;
        }

    }
}
