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
package org.aksw.simba.cetus.yago;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVReader;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDFS;

public class YagoClassHierarchyLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(YagoClassHierarchyLoader.class);

    public static final String YAGO_NAMESPACE = "http://yago-knowledge.org/resource/";

    private static final int SUBJECT_ID = 1;
    private static final int PREDICATE_ID = 2;
    private static final int ObJECT_ID = 3;

    public void readClassHierarchy(File file, Model model) throws IOException {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            readClassHierarchy(fin, model);
        } finally {
            IOUtils.closeQuietly(fin);
        }
    }

    public void readClassHierarchy(InputStream is, Model model) throws IOException {
        InputStreamReader isReader = null;
        CSVReader csvReader = null;
        try {
            isReader = new InputStreamReader(is);
            csvReader = new CSVReader(isReader, '\t');
            String line[] = csvReader.readNext();
            int counter = 0;
            Resource subjectResource, objectResource;
            while (line != null) {
                if ((line.length >= 4) && ("rdfs:subClassOf".equals(line[PREDICATE_ID]))) {
                    // check that subject and object start with '<' and end with
                    // '>'
                    if (line[SUBJECT_ID].startsWith("<") && line[SUBJECT_ID].endsWith(">")
                            && line[ObJECT_ID].startsWith("<") && line[ObJECT_ID].endsWith(">")) {
                        subjectResource = model.createResource(YAGO_NAMESPACE
                                + line[SUBJECT_ID].substring(1, line[SUBJECT_ID].length() - 1));
                        objectResource = model.createResource(YAGO_NAMESPACE
                                + line[ObJECT_ID].substring(1, line[ObJECT_ID].length() - 1));
                        model.add(subjectResource, RDFS.subClassOf, objectResource);
                    }
                    ++counter;
                }
                line = csvReader.readNext();
            }
            LOGGER.info("Loaded " + counter + " rdfs:subClassOf relations.");
        } finally {
            if (csvReader != null) {
                try {
                    csvReader.close();
                } catch (Exception e) {
                }
            }
            IOUtils.closeQuietly(isReader);
        }
    }
}
