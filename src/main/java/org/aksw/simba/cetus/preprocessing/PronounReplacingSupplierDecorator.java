package org.aksw.simba.cetus.preprocessing;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.aksw.simba.topicmodeling.preprocessing.docsupplier.DocumentSupplier;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.AbstractDocumentSupplierDecorator;
import org.aksw.simba.topicmodeling.utils.doc.Document;
import org.aksw.simba.topicmodeling.utils.doc.DocumentText;
import org.aksw.simba.topicmodeling.utils.doc.ner.NamedEntitiesInText;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.stanford.nlp.pipeline.DeterministicCorefAnnotator;

@Deprecated
public class PronounReplacingSupplierDecorator extends AbstractDocumentSupplierDecorator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PronounReplacingSupplierDecorator.class);

    private static final String STANFORD_NLP_PROPERTIES_FILE = "stanfordNLP.properties";

    public static PronounReplacingSupplierDecorator create(DocumentSupplier documentSource) {
        Properties props = new Properties();
        InputStream is;
        is = PronounReplacingSupplierDecorator.class.getClassLoader().getResourceAsStream(STANFORD_NLP_PROPERTIES_FILE);
        if (is == null) {
            LOGGER.error("Couldn't load stanford properties file (\"" + STANFORD_NLP_PROPERTIES_FILE
                    + "\") from class path. Returning null.");
            return null;
        }
        try {
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("Couldn't load stanford properties file. Returning null.", e);
            return null;
        } finally {
            IOUtils.closeQuietly(is);
        }
        DeterministicCorefAnnotator annotator = new DeterministicCorefAnnotator(props);
        return new PronounReplacingSupplierDecorator(documentSource, annotator);
    }

    @SuppressWarnings("unused")
    private DeterministicCorefAnnotator annotator;

    protected PronounReplacingSupplierDecorator(DocumentSupplier documentSource, DeterministicCorefAnnotator annotator) {
        super(documentSource);
        this.annotator = annotator;
    }

    @Override
    protected Document prepareDocument(Document document) {
        DocumentText text = document.getProperty(DocumentText.class);
        if (text == null) {
            LOGGER.error("Got a document without the needed DocumentText property. Ignoring it.");
            return document;
        }
        NamedEntitiesInText nes = document.getProperty(NamedEntitiesInText.class);
        if (nes == null) {
            LOGGER.error("Got a document without the needed NamedEntitiesInText property. Ignoring it.");
            return document;
        }
        addEntityMentions(text.getText(), nes);
        return document;
    }

    private void addEntityMentions(String text, NamedEntitiesInText nes) {
        // annotator.annotate(annotation);
        // TODO
    }
}
