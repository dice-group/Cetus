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
						+ "FictionalVillain",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"fictional villain"),
				new ExtendedTypedNamedEntity(28, 7,
					CetusSurfaceFormExtractor.BASE_URI
						+ "Villain",
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
						+ "HoldingCompany",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"holding company"),
				new ExtendedTypedNamedEntity(109, 7,
					CetusSurfaceFormExtractor.BASE_URI
						+ "Company",
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
						+ "FootballClub",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"football club"),
				new ExtendedTypedNamedEntity(48, 4,
					CetusSurfaceFormExtractor.BASE_URI
						+ "Club", new HashSet<String>(
						Arrays.asList(RDFS.Class
							.getURI())), "club"))) });
	testConfigs
		.add(new Object[] {
			new DocumentImpl(
				"A CPU socket or CPU slot is a mechanical component that provides mechanical and electrical connections between a microprocessor and a printed circuit board .",
				Arrays.asList((Marking) new NamedEntity(2, 10,
					"http://dbpedia.org/resource/CPU_socket"))),
			new HashSet<ExtendedTypedNamedEntity>(Arrays.asList(
				new ExtendedTypedNamedEntity(30, 20,
					CetusSurfaceFormExtractor.BASE_URI
						+ "MechanicalComponent",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"mechanical component"),
				new ExtendedTypedNamedEntity(41, 9,
					CetusSurfaceFormExtractor.BASE_URI
						+ "Component",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"component"))) });
	testConfigs
		.add(new Object[] {
			new DocumentImpl(
				"An Abbe refractometer is a bench-top device for the high-precision measurement of an index of refraction.",
				Arrays.asList((Marking) new NamedEntity(3, 18,
					"http://dbpedia.org/resource/Abbe_refractometer"))),
			new HashSet<ExtendedTypedNamedEntity>(Arrays.asList(
				new ExtendedTypedNamedEntity(27, 16,
					CetusSurfaceFormExtractor.BASE_URI
						+ "Bench-topDevice",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"bench-top device"),
				new ExtendedTypedNamedEntity(37, 6,
					CetusSurfaceFormExtractor.BASE_URI
						+ "Device",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"device"))) });
	testConfigs
		.add(new Object[] {
			new DocumentImpl(
				"Štvrtok is a village in Trencín District in the Trencín Region of north-western Slovakia.",
				Arrays.asList((Marking) new NamedEntity(0, 7,
					"http://dbpedia.org/resource/Štvrtok"))),
			new HashSet<ExtendedTypedNamedEntity>(Arrays
				.asList(new ExtendedTypedNamedEntity(13, 7,
					CetusSurfaceFormExtractor.BASE_URI
						+ "Village",
					new HashSet<String>(Arrays
						.asList(RDFS.Class.getURI())),
					"village"))) });
	return testConfigs;
    }

    private static final CetusSurfaceFormExtractor EXTRACTOR = CetusSurfaceFormExtractor
	    .create();

    public Document nifDocument;
    public Set<ExtendedTypedNamedEntity> expectedTypes;

    public CetusSurfaceFormExtractorTest(Document nifDocument,
	    Set<ExtendedTypedNamedEntity> expectedTypes) {
	this.nifDocument = nifDocument;
	this.expectedTypes = expectedTypes;
    }

    @Test
    public void test() {
	Map<NamedEntity, List<ExtendedTypedNamedEntity>> result = EXTRACTOR
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
