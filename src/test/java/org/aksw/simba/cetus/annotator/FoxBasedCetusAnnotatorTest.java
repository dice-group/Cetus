/**
 * Cetus - Cetus performs Entity Typing Using patternS
 * Copyright © 2015 Data Science Group (DICE) (michael.roeder@uni-paderborn.de)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.aksw.simba.cetus.annotator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.Marking;
import org.aksw.gerbil.transfer.nif.data.DocumentImpl;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.gerbil.transfer.nif.data.TypedNamedEntity;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;
import org.aksw.simba.cetus.fox.FoxBasedTypeSearcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.hpl.jena.vocabulary.RDFS;

@RunWith(Parameterized.class)
public class FoxBasedCetusAnnotatorTest {

    private static final Logger LOGGER = LoggerFactory
	    .getLogger(FoxBasedCetusAnnotatorTest.class);

    private static final String DOLCE_NAMESPACE = "http://www.ontologydesignpatterns.org/ont/";

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
						+ "FictionalVillain",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"fictional villain"),
				new ExtendedTypedNamedEntity(28, 7,
					CetusSurfaceFormExtractor.BASE_URI
						+ "Villain",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"villain"))),
			new HashSet<String>(
				Arrays.asList("http://www.ontologydesignpatterns.org/ont/dul/DUL.owl#Person")) });
	testConfigs
		.add(new Object[] {
			new DocumentImpl(
				"Avex Group Holdings Inc., listed in the Tokyo Stock Exchange as 7860 and abbreviated as AGHD, is the holding company for a group of entertainment-related subsidiaries based in Japan.",
				Arrays.asList((Marking) new NamedEntity(0, 24,
					"http://dbpedia.org/resource/Avex"))),
			new HashSet<ExtendedTypedNamedEntity>(Arrays.asList(
				new ExtendedTypedNamedEntity(101, 15,
					CetusSurfaceFormExtractor.BASE_URI
						+ "HoldingCompany",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"holding company"),
				new ExtendedTypedNamedEntity(109, 7,
					CetusSurfaceFormExtractor.BASE_URI
						+ "Company",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"company"))),
			new HashSet<String>(
				Arrays.asList("http://www.ontologydesignpatterns.org/ont/dul/DUL.owl#Organization")) });

	return testConfigs;
    }

    private static final CetusAnnotator ANNOTATOR = new CetusAnnotator(
	    CetusSurfaceFormExtractor.create(), new FoxBasedTypeSearcher());

    public Document nifDocument;
    public Set<ExtendedTypedNamedEntity> expectedTypesInText;
    public Set<String> expectedTypes;

    public FoxBasedCetusAnnotatorTest(Document nifDocument,
	    Set<ExtendedTypedNamedEntity> expectedTypesInText,
	    Set<String> expectedTypes) {
	this.nifDocument = nifDocument;
	this.expectedTypesInText = expectedTypesInText;
	this.expectedTypes = expectedTypes;
    }

    @Test
    public void test() {
	Document resultDoc = ANNOTATOR.performTypeExtraction(nifDocument);

	List<ExtendedTypedNamedEntity> typesInText = resultDoc
		.getMarkings(ExtendedTypedNamedEntity.class);
	for (ExtendedTypedNamedEntity typeInText : typesInText) {
	    Assert.assertTrue("Couldn't find " + typeInText
		    + " inside the list of expected types.",
		    expectedTypesInText.contains(typeInText));
	}
	Assert.assertEquals(expectedTypesInText.size(), typesInText.size());

	List<TypedNamedEntity> typedNEs = resultDoc
		.getMarkings(TypedNamedEntity.class);
	for (TypedNamedEntity typedNE : typedNEs) {
	    if (!(typedNE instanceof ExtendedTypedNamedEntity)) {
		LOGGER.debug("Found "
			+ Arrays.toString(expectedTypes.toArray()));
		for (String typeURI : typedNE.getTypes()) {
		    if (typeURI.startsWith(DOLCE_NAMESPACE)) {
			if (expectedTypes.contains(typeURI)) {
			    expectedTypes.remove(typeURI);
			} else {
			    LOGGER.warn("Found an unmatched DOLCE URI: "
				    + typeURI);
			}
		    }
		}
	    }
	}
	Assert.assertEquals(
		"The types " + Arrays.toString(expectedTypes.toArray())
			+ " couldn't be found.", 0, expectedTypes.size());
    }
}
