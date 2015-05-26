package org.aksw.simba.cetus.annotator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.Marking;
import org.aksw.gerbil.transfer.nif.data.DocumentImpl;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.hp.hpl.jena.vocabulary.RDFS;

@RunWith(Parameterized.class)
public class CetusSurfaceFormExtractorTest {

    @Parameters
    public static Collection<Object[]> data() {
	List<Object[]> testConfigs = new ArrayList<Object[]>();
	testConfigs
		.add(new Object[] {
			new DocumentImpl(
				"Brian Banner is a fictional villain from the Marvel Comics Universe created by Bill Mantlo and Mike Mignola and first appearing in print in late 1985.",
				Arrays.asList((Marking) new NamedEntity(0, 12,
					"http://dbpedia.org/resource/Brian_Banner"))),
			new HashSet<ExtendedTypedNamedEntity>(Arrays.asList(
				new ExtendedTypedNamedEntity(18, 17,
					CetusSurfaceFormExtractor.BASE_URI
						+ "fictionalVillain",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"fictional villain"),
				new ExtendedTypedNamedEntity(28, 7,
					CetusSurfaceFormExtractor.BASE_URI
						+ "villain",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"villain"))) });
	testConfigs
		.add(new Object[] {
			new DocumentImpl(
				"Avex Group Holdings Inc., listed in the Tokyo Stock Exchange as 7860 and abbreviated as AGHD, is the holding company for a group of entertainment-related subsidiaries based in Japan.",
				Arrays.asList((Marking) new NamedEntity(0, 24,
					"http://dbpedia.org/resource/Avex"))),
			new HashSet<ExtendedTypedNamedEntity>(Arrays.asList(
				new ExtendedTypedNamedEntity(101, 15,
					CetusSurfaceFormExtractor.BASE_URI
						+ "holdingCompany",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"holding company"),
				new ExtendedTypedNamedEntity(109, 7,
					CetusSurfaceFormExtractor.BASE_URI
						+ "company",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"company"))) });
	testConfigs
		.add(new Object[] {
			new DocumentImpl(
				"Associação Desportiva Sanjoanense is a football club based in S‹o Jo‹o da Madeira.",
				Arrays.asList((Marking) new NamedEntity(0, 33,
					"http://dbpedia.org/resource/FB"))),
			new HashSet<ExtendedTypedNamedEntity>(Arrays.asList(
				new ExtendedTypedNamedEntity(39, 13,
					CetusSurfaceFormExtractor.BASE_URI
						+ "footballClub",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"football club"),
				new ExtendedTypedNamedEntity(48, 4,
					CetusSurfaceFormExtractor.BASE_URI
						+ "club", new HashSet<String>(
						Arrays.asList(RDFS.Class
							.getURI())), "club"))) });
	return testConfigs;
    }

    public Document nifDocument;
    public Set<ExtendedTypedNamedEntity> expectedTypes;

    public CetusSurfaceFormExtractorTest(Document nifDocument,
	    Set<ExtendedTypedNamedEntity> expectedTypes) {
	this.nifDocument = nifDocument;
	this.expectedTypes = expectedTypes;
    }

    @Test
    public void test() {
	CetusSurfaceFormExtractor extractor = CetusSurfaceFormExtractor
		.create();

	Map<NamedEntity, List<ExtendedTypedNamedEntity>> result = extractor
		.extractTypeSurfaceForms(nifDocument);
	List<ExtendedTypedNamedEntity> resultTypes;
	for (NamedEntity ne : nifDocument.getMarkings(NamedEntity.class)) {
	    Assert.assertTrue(result.containsKey(ne));
	    resultTypes = result.get(ne);
	    for (ExtendedTypedNamedEntity types : resultTypes) {
		Assert.assertTrue("Couldn't find " + types
			+ " inside the list of expected types.",
			expectedTypes.contains(types));
	    }
	    Assert.assertEquals(expectedTypes.size(), resultTypes.size());
	}
    }
}
