/**
 * The MIT License
 * Copyright (c) 2015 Agile Knowledge Engineering and Semantic Web (AKSW) (usbeck@informatik.uni-leipzig.de)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.aksw.simba.cetus.tools;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.aksw.simba.cetus.datatypes.DescribedEntity;
import org.aksw.simba.cetus.datatypes.DescribedEntityType;
import org.aksw.simba.cetus.datatypes.SimplePatternInTokenizedText;
import org.aksw.simba.cetus.preprocessing.BracketsRemovingSupplierDecorator;
import org.aksw.simba.cetus.preprocessing.CetusSPARQLDocumentSupplier;
import org.aksw.simba.cetus.preprocessing.EntityAndTypeIdentificationInText;
import org.aksw.simba.cetus.preprocessing.EntityWasFoundDocumentFilter;
import org.aksw.simba.cetus.preprocessing.QuotesRemovingSupplierDecorator;
import org.aksw.simba.cetus.preprocessing.SimplePatternExtractor;
import org.aksw.simba.topicmodeling.lang.Language;
import org.aksw.simba.topicmodeling.lang.SentenceSplitterFactory;
import org.aksw.simba.topicmodeling.lang.Term;
import org.aksw.simba.topicmodeling.lang.postagging.StanfordTaggerWrapper;
import org.aksw.simba.topicmodeling.preprocessing.docconsumer.DocumentConsumer;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.DocumentSupplier;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.DocumentFilteringSupplierDecorator;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.ner.NerPropagatingSupplierDecorator;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.splitter.SentenceBasedDocumentTextSplitter;
import org.aksw.simba.topicmodeling.utils.doc.Document;
import org.aksw.simba.topicmodeling.utils.doc.TermTokenizedText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVWriter;

public class PatternExtractor implements DocumentConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatternExtractor.class);

    public static final String OUTPUT_FILE = "patterns.csv";

    public static final String ENTITY_PLACEHOLDER = "$ENTITY$";
    public static final String TYPE_PLACEHOLDER = "$TYPE$";

    public static void main(String[] args) {
        PatternExtractor extractor = new PatternExtractor();
        extractor.run(new File(OUTPUT_FILE));
    }

    private FileWriter fWriter;
    private CSVWriter cWriter;

    private void run(File outputFile) {
        if (!open(outputFile)) {
            LOGGER.error("Couldn't open file. Aborting.");
            return;
        }

        DocumentSupplier supplier = new CetusSPARQLDocumentSupplier(DataExtractor.SPARQL_ENDPOINT);
        // remove quotes
        supplier = new QuotesRemovingSupplierDecorator(supplier);
        // remove brackets
        supplier = new BracketsRemovingSupplierDecorator(supplier);
        // split sentences
        supplier = new SentenceBasedDocumentTextSplitter(supplier,
                SentenceSplitterFactory.createSentenceSplitter(Language.ENG));
        // find the entity and its type inside the text
        supplier = new EntityAndTypeIdentificationInText(supplier);
        // filter documents if their entity or type couldn't be found
        supplier = new DocumentFilteringSupplierDecorator(supplier, new EntityWasFoundDocumentFilter(
                DescribedEntity.class));
        supplier = new DocumentFilteringSupplierDecorator(supplier, new EntityWasFoundDocumentFilter(
                DescribedEntityType.class));
        // POS tagging
        // supplier = new NerPropagatingSupplierDecorator(supplier,
        // PosTaggerFactory.getPosTaggingStep(Language.ENG));
        supplier = new NerPropagatingSupplierDecorator(supplier, StanfordTaggerWrapper.create());
        // Pattern creation
        supplier = new SimplePatternExtractor(supplier);

        try {
            // processing and storage
            Document document = supplier.getNextDocument();
            int count = 0;
            while (document != null) {
                this.consumeDocument(document);
                ++count;
                if ((count % 10000) == 0) {
                    LOGGER.info("Consumed the " + count + "th document.");
                }
                document = supplier.getNextDocument();
            }
        } catch (Exception e) {
            LOGGER.error("Got an unexpected exception. Aborting.", e);
        } finally {
            close();
        }
    }

    @Override
    public void consumeDocument(Document document) {
        DescribedEntity entity = document.getProperty(DescribedEntity.class);
        if (entity == null) {
            return;
        }
        DescribedEntityType type = document.getProperty(DescribedEntityType.class);
        if (type == null) {
            return;
        }
        TermTokenizedText tttext = document.getProperty(TermTokenizedText.class);
        if (tttext == null) {
            return;
        }
        SimplePatternInTokenizedText pattern = document.getProperty(SimplePatternInTokenizedText.class);
        if (pattern == null) {
            return;
        }
        String patternString = generatePatternString(tttext, pattern);
        cWriter.writeNext(new String[] { entity.get().getNamedEntityUri(), entity.get().getLabel(), patternString,
                type.get().getLabel(), type.get().getNamedEntityUri() });
    }

    private String generatePatternString(TermTokenizedText tttext, SimplePatternInTokenizedText pattern) {
        int start = pattern.getStart(), end = pattern.getEnd();
        List<Term> terms = tttext.getTermTokenizedText();
        Term term;

        StringBuilder builder = new StringBuilder();
        if (pattern.startsWithEntity()) {
            builder.append(ENTITY_PLACEHOLDER);
        } else {
            builder.append(TYPE_PLACEHOLDER);
        }

        for (int i = start; i < end; ++i) {
            builder.append(' ');
            term = terms.get(i);
            builder.append(term.wordForm);
            builder.append('_');
            builder.append(term.lemma);
            builder.append('_');
            builder.append(term.posTag);
        }

        builder.append(' ');
        if (pattern.startsWithEntity()) {
            builder.append(TYPE_PLACEHOLDER);
        } else {
            builder.append(ENTITY_PLACEHOLDER);
        }

        return builder.toString();
    }

    private boolean open(File outputFile) {
        try {
            fWriter = new FileWriter(outputFile);
            cWriter = new CSVWriter(fWriter);
            return true;
        } catch (Exception e) {
            LOGGER.error("Couldn't open output file. Returning false.");
            return false;
        }
    }

    private void close() {
        if (fWriter != null) {
            try {
                fWriter.close();
            } catch (Exception e) {
            }
        }
        if (cWriter != null) {
            try {
                cWriter.close();
            } catch (Exception e) {
            }
        }
    }
}
