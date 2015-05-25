package org.aksw.simba.cetus.yago;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
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

    // private static final String UNKINKED_CLASSES_QUERY =
    // "SELECT ?s WHERE { ?s ?p ?o\n FILTER NOT EXISTS {?s <http://www.w3.org/2002/07/owl#equivalentClass> ?x} .\n FILTER NOT EXISTS { ?y <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?s .}}";

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

        LOGGER.info("Loading DOLCE classes...");
        // load DOLCE ontology
        Model dolceClassModel = ModelFactory.createDefaultModel();
        if (!loadDolceClasses(dolceClassModel)) {
            return null;
        }
        return new YagoBasedTypeSearcher(classModel, dolceClassModel);
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
            is = new FileInputStream("/Daten/cetus_data/classes.ttl");
            classModel.read(is, null, "TTL");
            return true;
        } catch (IOException e) {
            LOGGER.error("Couldn't load Model containing YAGO and DOLCE classes. Returning null.", e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return false;
    }

    protected static boolean loadDolceClasses(Model classModel) {
        DolceClassHierarchyLoader loader = new DolceClassHierarchyLoader();
        try {
            // FIXME put the path into properties file
            loader.readClassHierarchy(new File("/Daten/cetus_data/DOLCE"), classModel);
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
        NodeIterator nodeIterator;
        ResIterator resIterator;
        boolean addClass;
        while (!queue.isEmpty()) {
            classResource = queue.poll();
            if (dolceClassModel.containsResource(classResource)) {
                nodeIterator = dolceClassModel.listObjectsOfProperty(classResource, RDFS.subClassOf);
                while (nodeIterator.hasNext()) {
                    superClass = nodeIterator.next().asResource();
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
                    }
                }
            }
        }
    }

    private Model classesModel;
    private Model dolceClassModel;
    /**
     * A list of DOLCE classes to which we can not traverse starting inside the
     * YAGO hierarchy (and going only up or to the side).
     */
    private Set<Resource> unlinkedDolceClasses;

    protected YagoBasedTypeSearcher(Model classesModel, Model dolceClassModel) {
        this.classesModel = classesModel;
        this.dolceClassModel = dolceClassModel;
        LOGGER.info("Searching unlinked DOLCE classes...");
        this.unlinkedDolceClasses = findUnlinkedDolceClasses(classesModel, dolceClassModel);
        LOGGER.info("Creation finished.");
    }

    @Override
    public TypedNamedEntity getAllTypes(NamedEntity ne, List<ExtendedTypedNamedEntity> surfaceForms) {
        Set<Resource> types = new HashSet<Resource>();
        for (ExtendedTypedNamedEntity extTypNE : surfaceForms) {
            addMatchingClasses(extTypNE.getLabel(), types);
        }
        addSuperClasses(types);

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
        ResIterator resIterator = classesModel.listSubjectsWithProperty(RDFS.label, label);
        int count = 0;
        while (resIterator.hasNext()) {
            types.add(resIterator.next());
            ++count;
        }
        if (LOGGER.isInfoEnabled() && (count == 0)) {
            LOGGER.info("Couldn't find a matching YAGO class for the label \"" + label + "\".");
        }
    }

    protected void searchDolceSuperClasses(Set<Resource> types) {
        Queue<Resource> queue = new LinkedList<Resource>(types);
        Resource classResource, superClass;
        NodeIterator nodeIterator;
        Set<Resource> yagoSuperClasses = new HashSet<Resource>();
        Set<Resource> dolceSuperClasses = new HashSet<Resource>();
        boolean dolceClassFound = false;
        while (!queue.isEmpty()) {
            classResource = queue.poll();
            nodeIterator = classesModel.listObjectsOfProperty(classResource, RDFS.subClassOf);
            yagoSuperClasses.clear();
            dolceSuperClasses.clear();
            while (nodeIterator.hasNext()) {
                superClass = nodeIterator.next().asResource();
                if (dolceClassModel.containsResource(superClass)) {
                    dolceSuperClasses.add(superClass);
                } else {
                    yagoSuperClasses.add(superClass);
                }
            }

            // If a DOLCE class has been found
            if (dolceSuperClasses.size() > 0) {
                // add only the DOLCE classes and discard all others
                types.addAll(dolceSuperClasses);
                dolceClassFound = true;
            } else {
                for (Resource r : yagoSuperClasses) {
                    // If they have not been found before (and already have been
                    // added to the queue)
                    if (!types.contains(r)) {
                        types.add(r);
                        queue.add(r);
                    }
                }
            }
        }
        if (!dolceClassFound) {
            LOGGER.warn("Couldn't find a DOLCE class for the following list of types: "
                    + Arrays.toString(types.toArray()));
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
