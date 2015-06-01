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
