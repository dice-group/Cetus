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
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.aksw.simba.cetus.parser.TypeExtractor;
import org.aksw.simba.cetus.parser.antlr4.CetusPatternsBaseVisitor;
import org.aksw.simba.cetus.parser.antlr4.CetusPatternsParser.TypeContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class PatternMatchingTest extends CetusPatternsBaseVisitor<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatternMatchingTest.class);

    public static final String OUTPUT_FILE = "unmatchedPatterns.csv";

    public static void main(String[] args) {
        PatternMatchingTest test = new PatternMatchingTest();
        test.run(new File(PatternCounter.OUTPUT_FILE), new File(OUTPUT_FILE));
    }

    // private StrictErrorListener errorListener = new StrictErrorListener();

    private void run(File inputFile, File outputFile) {
        // System.out.println(getType("is_be_vbz a_a_dt type_type_n"));
        // System.out.println(getType("is_be_vbz a_a_dt yellow_yellow_j type_type_n"));
        // System.out.println(getType("is_be_vbz the_the_dt second_second_ord type_type_n"));

        FileReader fReader = null;
        CSVReader cReader = null;
        FileWriter fWriter = null;
        CSVWriter cWriter = null;
        try {
            fReader = new FileReader(inputFile);
            cReader = new CSVReader(fReader);
            fWriter = new FileWriter(outputFile);
            cWriter = new CSVWriter(fWriter);
            String line[] = cReader.readNext();
            int count = 0, matchedPatterns = 0, matchedCounts = 0, unmatchedPatterns = 0, unmatchedCounts = 0;
            String text;
            List<String> types;
            while (line != null) {
                text = line[0].replaceAll("\\$TYPE\\$", "type_type_NN");
                types = getTypes(text);
                if (types != null) {
                    ++matchedPatterns;
                    matchedCounts += Integer.parseInt(line[1]);
                    // for (String type : types) {
                    // if (type == null) {
                    // System.out.println("matched null. (text=\"" + text +
                    // "\")");
                    // } else {
                    // if (type.contains("null")) {
                    // System.out.println("matched \"" + type + "\". (text=\"" +
                    // text + "\")");
                    // }
                    // }
                    // }
                } else {
                    ++unmatchedPatterns;
                    unmatchedCounts += Integer.parseInt(line[1]);
                    cWriter.writeNext(line);
                }
                ++count;
                if ((count % 10000) == 0) {
                    LOGGER.info("Saw " + count + "th line.");
                }
                line = cReader.readNext();
            }
            System.out.println("matched patterns = "
                    + (matchedPatterns / (double) (matchedPatterns + unmatchedPatterns)) + " ("
                    + (matchedCounts / (double) (matchedCounts + unmatchedCounts)) + ")");
        } catch (Exception e) {
            LOGGER.error("Exception while reading patterns from file. Returning null.", e);
        } finally {
            if (cReader != null) {
                try {
                    cReader.close();
                } catch (Exception e) {
                }
            }
            if (fReader != null) {
                try {
                    fReader.close();
                } catch (Exception e) {
                }
            }
            if (cWriter != null) {
                try {
                    cWriter.close();
                } catch (Exception e) {
                }
            }
            if (fWriter != null) {
                try {
                    fWriter.close();
                } catch (Exception e) {
                }
            }
        }
    }

    private List<String> getTypes(String text) {
        TypeExtractor extractor = new TypeExtractor();
        return extractor.extractTypeStrings(text);
    }

    @Override
    public String visitType(TypeContext ctx) {
        return ctx.getText();
    }
}
