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
public class YagoBasedTypeSearcherFindUnlinkedDolceClassesTest {

    @Parameters
    public static Collection<Object[]> data() {
        List<Object[]> testConfigs = new ArrayList<Object[]>();
        Model classesModel, dolceClassModel;
        dolceClassModel = ModelFactory.createDefaultModel();
        Resource dolceA = dolceClassModel.createResource("http://dolce.org/dolceA");
        Resource dolceA1 = dolceClassModel.createResource("http://dolce.org/dolceA1");
        Resource dolceA2 = dolceClassModel.createResource("http://dolce.org/dolceA2");
        dolceClassModel.add(dolceA, RDF.type, RDFS.Class);
        dolceClassModel.add(dolceA1, RDF.type, RDFS.Class);
        dolceClassModel.add(dolceA2, RDF.type, RDFS.Class);
        dolceClassModel.add(dolceA1, RDFS.subClassOf, dolceA);
        dolceClassModel.add(dolceA2, RDFS.subClassOf, dolceA);
        classesModel = ModelFactory.createDefaultModel();
        classesModel.add(dolceClassModel);
        Resource yagoA2 = classesModel.createResource("http://yago.org/yagoA2");
        classesModel.add(yagoA2, OWL.equivalentClass, dolceA2);
        classesModel.add(yagoA2, RDF.type, RDFS.Class);
        testConfigs.add(new Object[] { classesModel, dolceClassModel, new HashSet<Resource>(Arrays.asList(dolceA1)) });

        dolceClassModel = ModelFactory.createDefaultModel();
        dolceA = dolceClassModel.createResource("http://dolce.org/dolceA");
        dolceA1 = dolceClassModel.createResource("http://dolce.org/dolceA1");
        Resource dolceA11 = dolceClassModel.createResource("http://dolce.org/dolceA11");
        Resource dolceA111 = dolceClassModel.createResource("http://dolce.org/dolceA111");
        Resource dolceA112 = dolceClassModel.createResource("http://dolce.org/dolceA112");
        dolceA2 = dolceClassModel.createResource("http://dolce.org/dolceA2");
        dolceClassModel.add(dolceA, RDF.type, RDFS.Class);
        dolceClassModel.add(dolceA1, RDF.type, RDFS.Class);
        dolceClassModel.add(dolceA2, RDF.type, RDFS.Class);
        dolceClassModel.add(dolceA11, RDF.type, RDFS.Class);
        dolceClassModel.add(dolceA111, RDF.type, RDFS.Class);
        dolceClassModel.add(dolceA112, RDF.type, RDFS.Class);

        dolceClassModel.add(dolceA1, RDFS.subClassOf, dolceA);
        dolceClassModel.add(dolceA2, RDFS.subClassOf, dolceA);
        dolceClassModel.add(dolceA11, RDFS.subClassOf, dolceA1);
        dolceClassModel.add(dolceA111, RDFS.subClassOf, dolceA11);
        dolceClassModel.add(dolceA112, RDFS.subClassOf, dolceA11);
        classesModel = ModelFactory.createDefaultModel();
        classesModel.add(dolceClassModel);
        yagoA2 = classesModel.createResource("http://yago.org/yagoA2");
        classesModel.add(yagoA2, OWL.equivalentClass, dolceA2);
        classesModel.add(yagoA2, RDF.type, RDFS.Class);
        testConfigs.add(new Object[] { classesModel, dolceClassModel,
                new HashSet<Resource>(Arrays.asList(dolceA1, dolceA11, dolceA111, dolceA112)) });

        dolceClassModel = ModelFactory.createDefaultModel();
        dolceA = dolceClassModel.createResource("http://dolce.org/dolceA");
        dolceA1 = dolceClassModel.createResource("http://dolce.org/dolceA1");
        dolceA11 = dolceClassModel.createResource("http://dolce.org/dolceA11");
        dolceA111 = dolceClassModel.createResource("http://dolce.org/dolceA111");
        dolceA112 = dolceClassModel.createResource("http://dolce.org/dolceA112");
        dolceA2 = dolceClassModel.createResource("http://dolce.org/dolceA2");
        Resource dolceA3 = dolceClassModel.createResource("http://dolce.org/dolceA3");
        Resource dolceA31 = dolceClassModel.createResource("http://dolce.org/dolceA31");
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
        yagoA2 = classesModel.createResource("http://yago.org/yagoA2");
        Resource yagoA21 = classesModel.createResource("http://yago.org/yagoA21");
        Resource yagoA22 = classesModel.createResource("http://yago.org/yagoA22");
        Resource yagoA3 = classesModel.createResource("http://yago.org/yagoA3");
        Resource yagoA32 = classesModel.createResource("http://yago.org/yagoA32");
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

        testConfigs.add(new Object[] { classesModel, dolceClassModel,
                new HashSet<Resource>(Arrays.asList(dolceA1, dolceA11, dolceA111, dolceA112, dolceA31)) });

        return testConfigs;
    }

    private Model classesModel;
    private Model dolceClassModel;
    private Set<Resource> expectedResult;

    public YagoBasedTypeSearcherFindUnlinkedDolceClassesTest(Model classesModel, Model dolceClassModel,
            Set<Resource> expectedResult) {
        this.classesModel = classesModel;
        this.dolceClassModel = dolceClassModel;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testFindUnlinkedDolceClasses() {
        ClassModelCreator.inferClassRelations(classesModel);
        Set<Resource> result = YagoBasedTypeSearcher.findUnlinkedDolceClasses(classesModel, dolceClassModel);
        for (Resource r : result) {
            Assert.assertTrue(r + " is not expected.", expectedResult.contains(r));
        }
        Assert.assertEquals(expectedResult.size(), result.size());
    }
}
