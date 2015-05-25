package org.aksw.simba.cetus.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.aksw.gerbil.io.nif.AbstractNIFParser;
import org.aksw.simba.cetus.dolce.DolceClassHierarchyLoader;
import org.aksw.simba.cetus.yago.YagoBasedTypeSearcher;
import org.aksw.simba.cetus.yago.YagoClassHierarchyLoader;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class ClassModelCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassModelCreator.class);

    private static final String TYPE_INFERENCE_RULES = "cetusTypeInferencerRules.txt";

    public static void main(String[] args) {
        Model classModel = ModelFactory.createDefaultModel();
        classModel.setNsPrefixes(YagoBasedTypeSearcher.getPrefixMapping());

        LOGGER.info("Loading YAGO classes...");
        // load YAGO class hierarchy
        if (!loadYagoClasses(classModel)) {
            return;
        }

        LOGGER.info("Loading DOLCE classes...");
        // load DOLCE ontology
        if (!loadDolceClasses(classModel)) {
            return;
        }

        LOGGER.info("Loading YAGO - DOLCE links...");
        // load links between YAGO and DOLCE
        if (!loadDolceLinks(classModel)) {
            return;
        }

        LOGGER.info("\"Manual\" SubClassInference ...");
        // load links between YAGO and DOLCE
        if (!inferClassRelations(classModel)) {
            return;
        }

        // LOGGER.info("Inferring sub classes...");
        // // infer needed class relations
        // if (!inferClassRelations_OLD(classModel)) {
        // return;
        // }
        LOGGER.info("Transforming model ...");
        classModel = escapeClassModel(classModel);

        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("/Daten/cetus_data/classes.ttl");
            classModel.write(fout, "TTL");
        } catch (Exception e) {
            LOGGER.error("Error while trying to write the class model to file.", e);
        } finally {
            IOUtils.closeQuietly(fout);
        }
    }

    protected static boolean loadYagoClasses(Model classModel) {
        YagoClassHierarchyLoader loader = new YagoClassHierarchyLoader();
        try {
            // FIXME put the path into properties file
            loader.readClassHierarchy(new File("/Daten/cetus_data/yagoTaxonomy.tsv"), classModel);
            return true;
        } catch (IOException e) {
            LOGGER.error("Couldn't load YAGO classes. Returning null.");
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

    protected static boolean loadDolceLinks(Model classModel) {
        FileInputStream is = null;
        try {
            // FIXME put the path into properties file
            is = new FileInputStream("/Daten/cetus_data/DOLCE_YAGO_links.nt");
            classModel.read(is, null, "N3");
            return true;
        } catch (IOException e) {
            LOGGER.error("Couldn't load DOLCE YAGO links. Returning null.", e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return false;
    }

    @Deprecated
    public static boolean inferClassRelations_OLD(Model classModel) {
        InputStream is = AbstractNIFParser.class.getClassLoader().getResourceAsStream(TYPE_INFERENCE_RULES);
        List<String> lines;
        try {
            lines = IOUtils.readLines(is);
        } catch (IOException e) {
            LOGGER.error("Couldn't load type inferencer rules from resource \"" + TYPE_INFERENCE_RULES
                    + "\". Working on the standard model.", e);
            return false;
        }
        IOUtils.closeQuietly(is);
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }

        Reasoner reasoner = new GenericRuleReasoner(Rule.parseRules(sb.toString()));
        InfModel infModel = ModelFactory.createInfModel(reasoner, classModel);
        classModel.add(infModel);
        return true;
    }

    public static boolean inferClassRelations(Model classModel) {
        Resource a, b;
        StmtIterator stmtIterator;
        Statement statement;

        // add class type
        stmtIterator = classModel.listStatements(null, RDFS.subClassOf, (RDFNode) null);
        while (stmtIterator.hasNext()) {
            statement = stmtIterator.next();
            a = statement.getSubject();
            b = statement.getObject().asResource();
            if (!classModel.contains(a, RDF.type, RDFS.Class)) {
                classModel.add(a, RDF.type, RDFS.Class);
            }
            if (!classModel.contains(b, RDF.type, RDFS.Class)) {
                classModel.add(b, RDF.type, RDFS.Class);
            }
        }

        // Add subclasses to equivalent classes
        stmtIterator = classModel.listStatements(null, OWL.equivalentClass, (RDFNode) null);
        List<Resource[]> pairs = new ArrayList<Resource[]>();
        while (stmtIterator.hasNext()) {
            statement = stmtIterator.next();
            a = statement.getSubject();
            b = statement.getObject().asResource();
            pairs.add(new Resource[] { a, b });
            addSubClassesOf(a, b, classModel);
            addSubClassesOf(b, a, classModel);
        }
        for (Resource[] pair : pairs) {
            if (!classModel.contains(pair[1], OWL.equivalentClass, pair[0])) {
                classModel.add(pair[1], OWL.equivalentClass, pair[0]);
            }
        }
        return true;
    }

    private static void addSubClassesOf(Resource clazz, Resource equivalentClass, Model classModel) {
        ResIterator iterator = classModel.listSubjectsWithProperty(RDFS.subClassOf, clazz);
        Set<Resource> subClasses = new HashSet<Resource>();
        while (iterator.hasNext()) {
            subClasses.add(iterator.next());
        }
        for (Resource subClass : subClasses) {
            if (!classModel.contains(subClass, RDFS.subClassOf, equivalentClass)) {
                classModel.add(subClass, RDFS.subClassOf, equivalentClass);
            }
        }
    }

    public static boolean inferSubClassRelations(Model classModel) {
        Set<Resource> subClasses = new HashSet<Resource>();
        ResIterator resIterator = classModel.listSubjectsWithProperty(RDFS.subClassOf);
        while (resIterator.hasNext()) {
            subClasses.add(resIterator.next());
        }
        LOGGER.info("Found " + subClasses.size() + " sub classes.");

        Queue<Resource> queue = new LinkedList<Resource>();
        int count = 0, count2 = 0;
        Resource resource, next;
        NodeIterator nodeIterator;
        Set<Resource> equalClasses = new HashSet<Resource>();
        Set<Resource> alreadySeen = new HashSet<Resource>();
        for (Resource subClass : subClasses) {
            equalClasses.clear();
            equalClasses.add(subClass);
            nodeIterator = classModel.listObjectsOfProperty(subClass, OWL.equivalentClass);
            while (nodeIterator.hasNext()) {
                equalClasses.add(nodeIterator.next().asResource());
            }
            resIterator = classModel.listSubjectsWithProperty(OWL.equivalentClass, subClass);
            while (resIterator.hasNext()) {
                equalClasses.add(resIterator.next());
            }
            for (Resource equalClass : equalClasses) {
                nodeIterator = classModel.listObjectsOfProperty(equalClass, RDFS.subClassOf);
                while (nodeIterator.hasNext()) {
                    queue.add(nodeIterator.next().asResource());
                }
            }
            alreadySeen.clear();
            while (!queue.isEmpty()) {
                resource = queue.poll();
                // mark this resource as super class of the sub class
                classModel.add(subClass, RDFS.subClassOf, resource);
                ++count2;
                if (!classModel.contains(resource, RDF.type, RDFS.Class)) {
                    classModel.add(resource, RDF.type, RDFS.Class);
                }

                nodeIterator = classModel.listObjectsOfProperty(resource, RDFS.subClassOf);
                while (nodeIterator.hasNext()) {
                    next = nodeIterator.next().asResource();
                    if (!alreadySeen.contains(next)) {
                        queue.add(next);
                        alreadySeen.add(next);
                    }
                }
            }
            ++count;
            if ((count % 100000) == 0) {
                LOGGER.info("processed " + count + " sub classes.");
            }
        }
        LOGGER.info("Added " + count2 + " properties.");
        return true;
    }

    public static Model escapeClassModel(Model classModel) {
        Model newClassModel = ModelFactory.createDefaultModel();
        newClassModel.setNsPrefixes(YagoBasedTypeSearcher.getPrefixMapping());
        StmtIterator stmtIterator = classModel.listStatements();
        Statement statement;
        String subjectUri, objectUri;
        while (stmtIterator.hasNext()) {
            statement = (Statement) stmtIterator.next();
            subjectUri = encodeUri(statement.getSubject().getURI());
            if (statement.getObject().isLiteral()) {
                newClassModel.add(newClassModel.getResource(subjectUri), statement.getPredicate(),
                        statement.getObject());
            } else {
                objectUri = encodeUri(statement.getObject().asResource().getURI());
                newClassModel.add(newClassModel.getResource(subjectUri), statement.getPredicate(), objectUri);
            }
        }
        return newClassModel;
    }

    public static String encodeUri(String uri) {
        StringBuilder builder = new StringBuilder();
        int start = uri.indexOf("://");
        if (start < 0) {
            return uri;
        }
        start += 3;
        builder.append(uri.substring(0, start));
        int end = uri.indexOf("/", start);
        try {
            while (end >= 0) {
                builder.append(URLEncoder.encode(uri.substring(start, end), "UTF-8"));
                builder.append('/');
                start = end + 1;
                end = uri.indexOf("/", start);
            }
            builder.append(URLEncoder.encode(uri.substring(start), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // shouldn't occur
            LOGGER.error("Unexpected exception.", e);
        }
        return builder.toString();
    }
}
