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
package org.aksw.simba.cetus.preprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.aksw.simba.cetus.datatypes.DescribedEntity;
import org.aksw.simba.cetus.datatypes.DescribedEntityType;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.AbstractDocumentSupplier;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.DocumentSupplier;
import org.aksw.simba.topicmodeling.utils.doc.Document;
import org.aksw.simba.topicmodeling.utils.doc.DocumentText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVReader;

public class CetusCSVDocumentSupplier extends AbstractDocumentSupplier {

    private static final Logger LOGGER = LoggerFactory.getLogger(CetusCSVDocumentSupplier.class);

    public static DocumentSupplier create(File rawDataFile) {
        FileReader fReader;
        try {
            fReader = new FileReader(rawDataFile);
            CSVReader cReader = new CSVReader(fReader);
            return new CetusCSVDocumentSupplier(fReader, cReader);
        } catch (FileNotFoundException e) {
            LOGGER.error("Exception while trying to open the given raw data file. Returning null.", e);
        }
        return null;
    }

    private FileReader fReader;
    private CSVReader cReader;

    protected CetusCSVDocumentSupplier(FileReader fReader, CSVReader cReader) {
        this.fReader = fReader;
        this.cReader = cReader;
    }

    @Override
    public Document getNextDocument() {
        Document document = null;
        if (cReader != null) {
            String line[];
            try {
                line = cReader.readNext();
                if (line != null) {
                    document = createDocument(line);
                }
            } catch (IOException e) {
                LOGGER.error("Exception while trying to read a line from the raw data file. Returning null.", e);
            }
            if (document == null) {
                try {
                    fReader.close();
                } catch (IOException e) {
                }
                fReader = null;
                try {
                    cReader.close();
                } catch (IOException e) {
                }
                cReader = null;
            }
        }
        return document;
    }

    private Document createDocument(String[] line) {
        if (line.length < 5) {
            LOGGER.error("The given CSV file line has less than the expected 5 values. Returning null.");
            return null;
        }
        Document document = new Document(getNextDocumentId());
        document.addProperty(new DocumentText(line[4]));
        document.addProperty(new DescribedEntity(line[1], line[0]));
        document.addProperty(new DescribedEntityType(line[3], line[2]));
        return document;
    }
}
