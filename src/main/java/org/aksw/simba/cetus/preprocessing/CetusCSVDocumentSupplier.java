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
