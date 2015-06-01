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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDFS;

@Ignore
@RunWith(Parameterized.class)
public class ExtendedYagoBasedTypeSearcherTest {

    private static final Logger LOGGER = LoggerFactory
	    .getLogger(ExtendedYagoBasedTypeSearcherTest.class);

    private static final String DOLCE_NAMESPACE = "http://www.ontologydesignpatterns.org/ont/";

    @Parameters
    public static Collection<Object[]> data() {
	List<Document> documents = ExtendedCetusSurfaceFormExtractorTest
		.loadDataset();
	List<Object[]> testConfigs = new ArrayList<Object[]>();
	for (Document document : documents) {
	    testConfigs.add(new Object[] { document,
		    extractNamedEntity(document), extractMarkings(document),
		    extractExpectedTypes(document) });
	}
	return testConfigs;
    }

    private static final CetusTypeSearcher SEARCHER = YagoBasedTypeSearcher
	    .create();

    public Document nifDocument;
    public NamedEntity namedEntity;
    public List<ExtendedTypedNamedEntity> surfaceForms;
    public Set<String> expectedTypes;

    public ExtendedYagoBasedTypeSearcherTest(Document nifDocument,
	    NamedEntity namedEntity,
	    List<ExtendedTypedNamedEntity> surfaceForms,
	    Set<String> expectedTypes) {
	this.nifDocument = nifDocument;
	this.namedEntity = namedEntity;
	this.surfaceForms = surfaceForms;
	this.expectedTypes = expectedTypes;
    }

    @Test
    public void test() {
	TypedNamedEntity tne = SEARCHER.getAllTypes(nifDocument, namedEntity,
		surfaceForms);
	boolean successful = true;
	for (String type : tne.getTypes()) {
	    if (type.startsWith(DOLCE_NAMESPACE)) {
		if (expectedTypes.contains(type)) {
		    expectedTypes.remove(type);
		} else {
		    LOGGER.warn("Couldn't find \"" + type
			    + "\" in the list of expected types ("
			    + Arrays.toString(tne.getTypes().toArray())
			    + "), document=\"" + nifDocument.getDocumentURI()
			    + "\".");
		    // successful = false;
		}
	    }
	}
	if (expectedTypes.size() != 0) {
	    LOGGER.warn("Couldn't find expected types \""
		    + Arrays.toString(expectedTypes.toArray())
		    + "), document=\"" + nifDocument.getDocumentURI() + "\".");
	    successful = false;
	}
	Assert.assertTrue(successful);
    }

    public static Set<String> extractExpectedTypes(Document document) {
	MarkingFilter<TypedNamedEntity> filter = new TypeBasedMarkingFilter<TypedNamedEntity>(
		false, RDFS.Class.getURI(), OWL.Class.getURI());
	List<TypedNamedEntity> namedEntities = document
		.getMarkings(TypedNamedEntity.class);
	Set<String> types = new HashSet<String>();
	for (TypedNamedEntity tne : namedEntities) {
	    if (filter.isMarkingGood(tne)) {
		for (String type : tne.getTypes()) {
		    if (type.startsWith(DOLCE_NAMESPACE)) {
			types.add(type);
		    }
		}
	    }
	}
	return types;
    }

    public static NamedEntity extractNamedEntity(Document document) {
	MarkingFilter<TypedNamedEntity> filter = new TypeBasedMarkingFilter<TypedNamedEntity>(
		false, RDFS.Class.getURI(), OWL.Class.getURI());
	List<TypedNamedEntity> namedEntities = document
		.getMarkings(TypedNamedEntity.class);
	for (TypedNamedEntity tne : namedEntities) {
	    if (filter.isMarkingGood(tne)) {
		return new NamedEntity(tne.getStartPosition(), tne.getLength(),
			tne.getUris());
	    }
	}
	return null;
    }

    public static List<ExtendedTypedNamedEntity> extractMarkings(
	    Document document) {
	MarkingFilter<TypedNamedEntity> filter = new TypeBasedMarkingFilter<TypedNamedEntity>(
		true, RDFS.Class.getURI(), OWL.Class.getURI());
	List<TypedNamedEntity> namedEntities = document
		.getMarkings(TypedNamedEntity.class);
	List<ExtendedTypedNamedEntity> extendedMarkings = new ArrayList<ExtendedTypedNamedEntity>();
	int start, length, end;
	for (TypedNamedEntity tne : namedEntities) {
	    if (filter.isMarkingGood(tne)) {
		start = tne.getStartPosition();
		length = tne.getLength();
		end = start + length;
		extendedMarkings.add(new ExtendedTypedNamedEntity(start,
			length, tne.getUris(), new HashSet<String>(), document
				.getText().substring(start, end)));
	    }
	}
	return extendedMarkings;
    }
}
