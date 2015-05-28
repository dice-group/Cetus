package org.aksw.simba.cetus.dolce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.jena.riot.RDFLanguages;
import org.apache.jena.riot.adapters.RDFReaderFactoryRIOT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFReader;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class DolceClassHierarchyLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(DolceClassHierarchyLoader.class);

    public static final String DUL_NAMESPACE = "http://www.ontologydesignpatterns.org/ont/dul/DUL.owl#";
    public static final String D0_NAMESPACE = "http://yago-knowledge.org/resource/";

    private static final String FILE_BASE_URI_MAPPING[][] = new String[][] {
            { "d0.owl.xml", "http://www.ontologydesignpatterns.org/ont/d0.owl" },
            { "DUL.owl.xml", "http://www.ontologydesignpatterns.org/ont/dul/DUL.owl" },
            { "CollectionsLite.owl.xml", "http://www.ontologydesignpatterns.org/ont/dul/CollectionsLite.owl" },
            { "Conceptualization.owl.xml", "http://www.ontologydesignpatterns.org/ont/dul/Conceptualization.owl" },
            { "ontopic.owl.xml", "http://www.ontologydesignpatterns.org/ont/dul/ontopic.owl" },
            { "Roles.owl.xml", "http://www.ontologydesignpatterns.org/ont/dul/Roles.owl" },
            { "Supplements.owl.xml", "http://www.ontologydesignpatterns.org/ont/dul/Supplements.owl" } };

    private static final Set<Property> DEFAULT_ALLOWED_PROPERTIES = new HashSet<Property>(Arrays.asList(RDF.type,
            RDFS.label, RDFS.subClassOf));

    private RDFReader xmlReader;

    public DolceClassHierarchyLoader() {
        RDFReaderFactoryRIOT factory = new RDFReaderFactoryRIOT();
        xmlReader = factory.getReader(RDFLanguages.RDFXML.getName());
    }

    public void readClassHierarchy(File directory, Model model) throws IOException {
        readClassHierarchy(directory, model, DEFAULT_ALLOWED_PROPERTIES);
    }

    public void readClassHierarchy(File directory, Model model, Set<Property> allowedProperties) throws IOException {
        if ((!directory.exists()) || (!directory.isDirectory())) {
            LOGGER.error("The given directory does not exist or is no directory. Aborting.");
            return;
        }
        Model readModel = ModelFactory.createDefaultModel();
        for (int i = 0; i < FILE_BASE_URI_MAPPING.length; ++i) {
            readClassHierarchy(new File(directory.getAbsolutePath() + File.separator + FILE_BASE_URI_MAPPING[i][0]),
                    FILE_BASE_URI_MAPPING[i][1], readModel);
        }
        Set<Resource> classes = getClasses(readModel);
        copyAllowedProperties(readModel, model, classes, allowedProperties);
    }

    protected void readClassHierarchy(File file, String baseUri, Model model) throws IOException {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            xmlReader.read(model, fin, baseUri);
        } finally {
            IOUtils.closeQuietly(fin);
        }
    }

    protected void copyAllowedProperties(Model readModel, Model model, Set<Resource> classes,
            Set<Property> allowedProperties) {
        StmtIterator stmtIterator = readModel.listStatements();
        Statement s;
        Literal label;
        while (stmtIterator.hasNext()) {
            s = stmtIterator.next();
            if (classes.contains(s.getSubject()) && allowedProperties.contains(s.getPredicate())
                    && (!s.getObject().isAnon())) {
                if (s.getPredicate().equals(RDFS.label)) {
                    label = s.getObject().asLiteral();
                    if (label.getLanguage().equals("en")) {
                        model.add(s.getSubject(), RDFS.label,
                                model.createLiteral(label.getString().toLowerCase(), "en"));
                    }
                } else {
                    model.add(s);
                }
            }
        }
    }

    protected Set<Resource> getClasses(Model readModel) {
        ResIterator iterator = readModel.listSubjectsWithProperty(RDF.type, RDFS.Class);
        Resource r;
        Set<Resource> classes = new HashSet<Resource>();
        while (iterator.hasNext()) {
            r = iterator.next();
            if (!r.isAnon()) {
                classes.add(r);
            }
        }
        iterator = readModel.listSubjectsWithProperty(RDF.type, OWL.Class);
        while (iterator.hasNext()) {
            r = iterator.next();
            if (!r.isAnon()) {
                classes.add(r);
            }
        }
        return classes;
    }

    public static void main(String[] args) {
        DolceClassHierarchyLoader loader = new DolceClassHierarchyLoader();
        Model model = ModelFactory.createDefaultModel();
        try {
            loader.readClassHierarchy(new File("cetus_data/DOLCE"), model);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("DOLCE_hierarchy.ttl");
            model.write(fout, "TTL");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fout);
        }
    }
}
