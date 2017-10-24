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
package org.aksw.simba.cetus.yago;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aksw.simba.cetus.tools.ClassModelCreator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

@RunWith(Parameterized.class)
public class YagoBasedTypeSearcherFindSuperClassesTest {

    @Parameters
    public static Collection<Object[]> data() {
	List<Object[]> testConfigs = new ArrayList<Object[]>();
	Model classesModel, dolceClassModel;

	dolceClassModel = ModelFactory.createDefaultModel();
	Resource dolceA = dolceClassModel
		.createResource("http://dolce.org/dolceA");
	Resource dolceA1 = dolceClassModel
		.createResource("http://dolce.org/dolceA1");
	Resource dolceA11 = dolceClassModel
		.createResource("http://dolce.org/dolceA11");
	Resource dolceA111 = dolceClassModel
		.createResource("http://dolce.org/dolceA111");
	Resource dolceA112 = dolceClassModel
		.createResource("http://dolce.org/dolceA112");
	Resource dolceA2 = dolceClassModel
		.createResource("http://dolce.org/dolceA2");
	Resource dolceA3 = dolceClassModel
		.createResource("http://dolce.org/dolceA3");
	Resource dolceA31 = dolceClassModel
		.createResource("http://dolce.org/dolceA31");
	dolceClassModel.add(dolceA, RDF.type, RDFS.Class);
	dolceClassModel.add(dolceA1, RDF.type, RDFS.Class);
	dolceClassModel.add(dolceA11, RDF.type, RDFS.Class);
	dolceClassModel.add(dolceA111, RDF.type, RDFS.Class);
	dolceClassModel.add(dolceA112, RDF.type, RDFS.Class);
	dolceClassModel.add(dolceA2, RDF.type, RDFS.Class);
	dolceClassModel.add(dolceA3, RDF.type, RDFS.Class);
	dolceClassModel.add(dolceA31, RDF.type, RDFS.Class);

	dolceClassModel.add(dolceA1, RDFS.subClassOf, dolceA);
	dolceClassModel.add(dolceA11, RDFS.subClassOf, dolceA1);
	dolceClassModel.add(dolceA111, RDFS.subClassOf, dolceA11);
	dolceClassModel.add(dolceA112, RDFS.subClassOf, dolceA11);
	dolceClassModel.add(dolceA2, RDFS.subClassOf, dolceA);
	dolceClassModel.add(dolceA3, RDFS.subClassOf, dolceA);
	dolceClassModel.add(dolceA31, RDFS.subClassOf, dolceA3);

	classesModel = ModelFactory.createDefaultModel();
	classesModel.add(dolceClassModel);
	Resource yagoA2 = classesModel.createResource("http://yago.org/yagoA2");
	Resource yagoA21 = classesModel
		.createResource("http://yago.org/yagoA21");
	Resource yagoA22 = classesModel
		.createResource("http://yago.org/yagoA22");
	Resource yagoA3 = classesModel.createResource("http://yago.org/yagoA3");
	Resource yagoA32 = classesModel
		.createResource("http://yago.org/yagoA32");
	classesModel.add(yagoA2, RDF.type, RDFS.Class);
	classesModel.add(yagoA21, RDF.type, RDFS.Class);
	classesModel.add(yagoA22, RDF.type, RDFS.Class);
	classesModel.add(yagoA3, RDF.type, RDFS.Class);
	classesModel.add(yagoA32, RDF.type, RDFS.Class);

	classesModel.add(yagoA21, RDFS.subClassOf, yagoA2);
	classesModel.add(yagoA22, RDFS.subClassOf, yagoA2);
	classesModel.add(yagoA32, RDFS.subClassOf, yagoA3);

	classesModel.add(yagoA2, OWL.equivalentClass, dolceA2);
	classesModel.add(yagoA3, OWL.equivalentClass, dolceA3);
	// yagoA21 is the result --> just go up to the first DOLCE type
	testConfigs.add(new Object[] { classesModel, dolceClassModel,
		new HashSet<Resource>(Arrays.asList(yagoA21)),
		new HashSet<Resource>(Arrays.asList(yagoA21, dolceA2)) });
	// yagoA22 is the result --> just go up to the first DOLCE type (Note,
	// that yagoA21 is not added!)
	testConfigs.add(new Object[] { classesModel, dolceClassModel,
		new HashSet<Resource>(Arrays.asList(yagoA22)),
		new HashSet<Resource>(Arrays.asList(yagoA22, dolceA2)) });
	// yagoA32 is the result
	testConfigs.add(new Object[] { classesModel, dolceClassModel,
		new HashSet<Resource>(Arrays.asList(yagoA32)),
		new HashSet<Resource>(Arrays.asList(yagoA32, dolceA3)) });
	// yagoA22 and yagoA32 are the results --> include all dolce classes up
	// to dolceA (dolceA1* and dolceA31 are not explicitly added)
	testConfigs.add(new Object[] {
		classesModel,
		dolceClassModel,
		new HashSet<Resource>(Arrays.asList(yagoA22, yagoA32)),
		new HashSet<Resource>(Arrays.asList(yagoA22, dolceA2, yagoA32,
			dolceA3, dolceA)) });
	return testConfigs;
    }

    private Model classesModel;
    private Model dolceClassModel;
    private Set<Resource> types;
    private Set<Resource> expectedResult;

    public YagoBasedTypeSearcherFindSuperClassesTest(Model classesModel, Model dolceClassModel,
	    Set<Resource> types, Set<Resource> expectedResult) {
	this.classesModel = classesModel;
	this.dolceClassModel = dolceClassModel;
	this.types = types;
	this.expectedResult = expectedResult;
    }

    @Test
    public void testFindUnlinkedDolceClasses() {
	ClassModelCreator.inferClassRelations(classesModel);
	YagoBasedTypeSearcher searcher = new YagoBasedTypeSearcher(
		classesModel, dolceClassModel, null);
	searcher.addSuperClasses(types);
	for (Resource r : types) {
	    Assert.assertTrue(r + " is not expected.",
		    expectedResult.contains(r));
	}
	Assert.assertEquals(expectedResult.size(), types.size());
    }
}
