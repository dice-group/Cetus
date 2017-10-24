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
