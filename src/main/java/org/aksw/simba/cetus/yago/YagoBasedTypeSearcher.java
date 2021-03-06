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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.gerbil.transfer.nif.data.TypedNamedEntity;
import org.aksw.simba.cetus.annotator.CetusTypeSearcher;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;
import org.aksw.simba.cetus.dolce.DolceClassHierarchyLoader;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.carrotsearch.hppc.BitSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.shared.PrefixMapping;
import com.hp.hpl.jena.shared.impl.PrefixMappingImpl;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class YagoBasedTypeSearcher implements CetusTypeSearcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(YagoBasedTypeSearcher.class);

    private static final String PREFIX_TO_NS_MAPPING[][] = new String[][] {
            { "yago", YagoClassHierarchyLoader.YAGO_NAMESPACE }, { "rdf", RDF.getURI() }, { "rdfs", RDFS.getURI() } };

    /**
     * We have found some resources to be not helpful if they are indexed. This
     * black list contains the URIs of these resources.
     */
    private static final Set<String> LABEL_INDEX_BLACK_LIST = new HashSet<String>(
            Arrays.asList("http://www.ontologydesignpatterns.org/ont/dul/DUL.owl#Region"));

    // private static final String UNKINKED_CLASSES_QUERY =
    // "SELECT ?s WHERE { ?s ?p ?o\n FILTER NOT EXISTS {?s
    // <http://www.w3.org/2002/07/owl#equivalentClass> ?x} .\n FILTER NOT EXISTS
    // { ?y <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?s .}}";

    public static void main(String[] args) {
        YagoBasedTypeSearcher.create();
    }

    public static YagoBasedTypeSearcher create() {
        Model classModel = ModelFactory.createDefaultModel();
        classModel.setNsPrefixes(getPrefixMapping());

        LOGGER.info("Loading classes model...");
        // load YAGO class hierarchy
        if (!loadClassModel(classModel)) {
            return null;
        }

        LOGGER.info("Loading label model...");
        // load YAGO labels
        Model labelModel = loadLabelModel();
        if (labelModel == null) {
            return null;
        }

        LOGGER.info("Creating label index...");
        Map<String, Resource[]> labelIndex = new HashMap<String, Resource[]>();
        addLabelsToIndex(labelIndex, classModel);
        addLabelsToIndex(labelIndex, labelModel);
        labelModel = null;

        LOGGER.info("Loading DOLCE classes...");
        // load DOLCE ontology
        Model dolceClassModel = ModelFactory.createDefaultModel();
        if (!loadDolceClasses(dolceClassModel)) {
            return null;
        }
        return new YagoBasedTypeSearcher(classModel, dolceClassModel, labelIndex);
    }

    public static PrefixMapping getPrefixMapping() {
        PrefixMapping mapping = new PrefixMappingImpl();
        for (int i = 0; i < PREFIX_TO_NS_MAPPING.length; ++i) {
            mapping.setNsPrefix(PREFIX_TO_NS_MAPPING[i][0], PREFIX_TO_NS_MAPPING[i][1]);
        }
        return mapping;
    }

    protected static boolean loadClassModel(Model classModel) {
        FileInputStream is = null;
        try {
            // FIXME put the path into properties file
            is = new FileInputStream("cetus_data/classes.ttl");
            classModel.read(is, null, "TTL");
            return true;
        } catch (IOException e) {
            LOGGER.error("Couldn't load Model containing YAGO and DOLCE classes. Returning null.", e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return false;
    }

    protected static Model loadLabelModel() {
        Model labelModel = ModelFactory.createDefaultModel();
        FileInputStream is = null;
        try {
            // FIXME put the path into properties file
            is = new FileInputStream("cetus_data/yago_class_labels.ttl");
            labelModel.read(is, null, "TTL");
            return labelModel;
        } catch (IOException e) {
            LOGGER.error("Couldn't load model containing YAGO labels. Returning null.", e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return null;
    }

    protected static void addLabelsToIndex(Map<String, Resource[]> labelIndex, Model model) {
        StmtIterator stmtIterator = model.listStatements(null, RDFS.label, (RDFNode) null);
        Statement statement;
        String label;
        Resource resources[];
        Resource subject;
        while (stmtIterator.hasNext()) {
            statement = stmtIterator.next();
            subject = statement.getSubject();
            if (!LABEL_INDEX_BLACK_LIST.contains(subject.getURI())) {
                label = statement.getObject().asLiteral().getString();
                if (labelIndex.containsKey(label)) {
                    resources = labelIndex.get(label);
                    resources = Arrays.copyOf(resources, resources.length + 1);
                    resources[resources.length - 1] = subject;
                    labelIndex.put(label, resources);
                } else {
                    labelIndex.put(label, new Resource[] { subject });
                }
            }
        }
    }

    protected static boolean loadDolceClasses(Model classModel) {
        DolceClassHierarchyLoader loader = new DolceClassHierarchyLoader();
        try {
            // FIXME put the path into properties file
            loader.readClassHierarchy(new File("cetus_data/DOLCE"), classModel);
            return true;
        } catch (IOException e) {
            LOGGER.error("Couldn't load DOLCE classes. Returning null.");
        }
        return false;
    }

    protected static Set<Resource> findUnlinkedDolceClasses(Model classesModel, Model dolceClassModel) {
        Set<Resource> unlinkedClasses = new HashSet<Resource>();
        StmtIterator stmtIterator = dolceClassModel.listStatements(null, RDF.type, RDFS.Class);
        Statement statement;
        Resource resource;
        while (stmtIterator.hasNext()) {
            statement = stmtIterator.next();
            resource = statement.getSubject();
            // If this class has no equivalent class and no sub classes
            if ((!classesModel.contains(resource, OWL.equivalentClass))
                    && (!classesModel.contains(null, OWL.equivalentClass, resource))
                    && (!classesModel.contains(null, RDFS.subClassOf, resource))) {
                unlinkedClasses.add(resource);
            }
        }
        // We are searching the higher classes on the complete model to make
        // sure, that higher DOLCE classes are only added to the list of
        // unlinked classes, if they do not have a YAGO sub class
        // FIXME If a DOLCE class has an equal YAGO class and both have no
        // children, the DOLCE class will be added to the list of unlinked
        // classes. (very unlikely, but possible)
        addHigherIncludedDolceClass(unlinkedClasses, classesModel, unlinkedClasses);

        return unlinkedClasses;
    }

    protected static void addHigherIncludedDolceClass(Set<Resource> classes, Model dolceClassModel,
            Set<Resource> unlinkedDolceClasses) {
        Queue<Resource> queue = new LinkedList<Resource>(classes);
        Resource classResource, superClass, subClass;
        RDFNode node;
        NodeIterator nodeIterator;
        ResIterator resIterator;
        boolean addClass;
        while (!queue.isEmpty()) {
            classResource = queue.poll();
            if (dolceClassModel.containsResource(classResource)) {
                nodeIterator = dolceClassModel.listObjectsOfProperty(classResource, RDFS.subClassOf);
                while (nodeIterator.hasNext()) {
                    node = nodeIterator.next();
                    if (node.isResource()) {
                        superClass = node.asResource();
                        // get all sub classes of this class
                        resIterator = dolceClassModel.listSubjectsWithProperty(RDFS.subClassOf, superClass);
                        addClass = true;
                        // Check that all sub classes of this super class are
                        // already in
                        // the list of classes or are marked as unlinked classes
                        while (resIterator.hasNext() && addClass) {
                            subClass = resIterator.next();
                            addClass = classes.contains(subClass) || unlinkedDolceClasses.contains(subClass);
                        }
                        if (addClass) {
                            classes.add(superClass);
                            queue.add(superClass);
                            if (LOGGER.isDebugEnabled()) {
                                LOGGER.debug("Added " + superClass.getURI());
                            }
                        }
                    } else {
                        LOGGER.error("Expected a resource in the statement (" + classResource + ", rdfs:subClassOf, "
                                + node + "). Ignoring this statement.");
                    }
                }
            }
        }
    }

    private Model classesModel;
    private Model dolceClassModel;
    private Map<String, Resource[]> labelIndex;
    /**
     * A list of DOLCE classes to which we can not traverse starting inside the
     * YAGO hierarchy (and going only up or to the side).
     */
    private Set<Resource> unlinkedDolceClasses;

    protected YagoBasedTypeSearcher(Model classesModel, Model dolceClassModel, Map<String, Resource[]> labelIndex) {
        this.classesModel = classesModel;
        this.dolceClassModel = dolceClassModel;
        this.labelIndex = labelIndex;
        LOGGER.info("Searching unlinked DOLCE classes...");
        this.unlinkedDolceClasses = findUnlinkedDolceClasses(classesModel, dolceClassModel);
        LOGGER.info("Creation finished.");
    }

    @Override
    public TypedNamedEntity getAllTypes(org.aksw.gerbil.transfer.nif.Document document, NamedEntity ne,
            List<ExtendedTypedNamedEntity> surfaceForms) {
        Set<Resource> types = new HashSet<Resource>();
        for (ExtendedTypedNamedEntity extTypNE : surfaceForms) {
            addMatchingClasses(extTypNE.getLabel(), types);
        }
        if (types.size() > 0) {
            addSuperClasses(types);
        } else {
            LOGGER.warn("Couldn't find any types.");
        }

        Set<String> typeURIs = transformTypeSet(types);
        for (ExtendedTypedNamedEntity extTypNE : surfaceForms) {
            typeURIs.addAll(extTypNE.getUris());
        }
        return new TypedNamedEntity(ne.getStartPosition(), ne.getLength(), ne.getUris(), typeURIs);
    }

    protected void addSuperClasses(Set<Resource> types) {
        searchDolceSuperClasses(types);
        addHigherIncludedDolceClass(types, dolceClassModel, unlinkedDolceClasses);
    }

    protected void addMatchingClasses(String label, Set<Resource> types) {
        Resource resources[];
        if (labelIndex.containsKey(label)) {
            List<Resource> matchingTypes = new ArrayList<Resource>();
            resources = labelIndex.get(label);
            for (int i = 0; i < resources.length; i++) {
                matchingTypes.add(resources[i]);
            }
            filterMatchingTypes(label, matchingTypes);
            types.addAll(matchingTypes);
            if (LOGGER.isDebugEnabled() && (resources.length > 0)) {
                LOGGER.debug("Added classes matching \"" + label + "\" --> " + Arrays.toString(resources));
            }
        } else {
            LOGGER.info("Couldn't find a matching YAGO class for the label \"" + label + "\".");
        }
        // ResIterator resIterator = classesModel.listSubjectsWithProperty(
        // RDFS.label, label);
        // int count = 0;
        // while (resIterator.hasNext()) {
        // types.add(resIterator.next());
        // ++count;
        // }
        // if (LOGGER.isInfoEnabled() && (count == 0)) {
        // LOGGER.info("Couldn't find a matching YAGO class for the label \""
        // + label + "\".");
        // }
    }

    private void filterMatchingTypes(String label, List<Resource> matchingTypes) {
        BitSet matchingDirectly = new BitSet(matchingTypes.size());
        BitSet matchingDolceTypes = new BitSet(matchingTypes.size());
        int id = 0;
        for (Resource matchingType : matchingTypes) {
            if (isMatchingDirectly(matchingType, label)) {
                matchingDirectly.set(id);
                if (dolceClassModel.containsResource(matchingType)) {
                    matchingDolceTypes.set(id);
                }
            }
            ++id;
        }
        if (matchingDirectly.isEmpty()) {
            return;
        }
        List<Resource> elementsToRemove = new ArrayList<Resource>(matchingTypes.size());
        BitSet goodTypes = matchingDolceTypes.isEmpty() ? matchingDirectly : matchingDolceTypes;
        id = 0;
        for (Resource matchingType : matchingTypes) {
            if (!goodTypes.get(id)) {
                elementsToRemove.add(matchingType);
            }
            ++id;
        }
        matchingTypes.removeAll(elementsToRemove);
    }

    private boolean isMatchingDirectly(Resource matchingType, String label) {
        String typeName = matchingType.getLocalName();
        if (typeName.startsWith("wordnet_")) {
            typeName = typeName.substring(8);
        }
        StringBuilder builder = new StringBuilder();
        char chars[] = typeName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                builder.append(' ');
            } else if (!Character.isDigit(chars[i])) {
                builder.append(Character.toLowerCase(chars[i]));
            }
        }
        typeName = builder.toString().trim();
        return typeName.equals(label);
    }

    protected void searchDolceSuperClasses(Set<Resource> types) {
        Queue<Resource> queue = new LinkedList<Resource>(types);
        Resource classResource, superClass;
        RDFNode node;
        NodeIterator nodeIterator;
        Set<Resource> yagoSuperClasses = new HashSet<Resource>();
        Set<Resource> dolceSuperClasses = new HashSet<Resource>();
        boolean dolceClassFound = false;
        while (!queue.isEmpty()) {
            classResource = queue.poll();
            // If this resource is a DOLCE resource
            if (dolceClassModel.containsResource(classResource)) {
                dolceClassFound = true;
            } else {
                nodeIterator = classesModel.listObjectsOfProperty(classResource, RDFS.subClassOf);
                yagoSuperClasses.clear();
                dolceSuperClasses.clear();
                while (nodeIterator.hasNext()) {
                    node = nodeIterator.next();
                    if (node.isResource()) {
                        superClass = node.asResource();
                        if (dolceClassModel.containsResource(superClass)) {
                            dolceSuperClasses.add(superClass);
                        } else {
                            yagoSuperClasses.add(superClass);
                        }
                    } else {
                        LOGGER.error("Expected a resource in the statement (" + classResource + ", rdfs:subClassOf, "
                                + node + "). Ignoring this statement.");
                    }
                }

                // If a DOLCE class has been found
                if (dolceSuperClasses.size() > 0) {
                    // add only the DOLCE classes and discard all others
                    types.addAll(dolceSuperClasses);
                    dolceClassFound = true;
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("Added super classes of " + classResource.getURI() + " --> "
                                + Arrays.toString(dolceSuperClasses.toArray()));
                    }
                } else {
                    for (Resource r : yagoSuperClasses) {
                        // If they have not been found before (and already have
                        // been
                        // added to the queue)
                        if (!types.contains(r)) {
                            types.add(r);
                            queue.add(r);
                        }
                        if (LOGGER.isDebugEnabled()) {
                            LOGGER.debug("Added super classes of " + classResource.getURI() + " --> "
                                    + Arrays.toString(yagoSuperClasses.toArray()));
                        }
                    }
                }
            }
        }
        if (!dolceClassFound) {
            LOGGER.warn(
                    "Couldn't find a DOLCE class for the following list of types: " + Arrays.toString(types.toArray()));
        }
    }

    private Set<String> transformTypeSet(Set<Resource> types) {
        Set<String> typeURIs = new HashSet<String>(types.size());
        for (Resource r : types) {
            typeURIs.add(r.getURI());
        }
        return typeURIs;
    }

}
