package org.aksw.simba.cetus.tools;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.aksw.simba.topicmodeling.commons.sort.AssociativeSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import com.carrotsearch.hppc.ObjectIntOpenHashMap;

public class PatternCounter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatternCounter.class);

    public static final String OUTPUT_FILE = "countedPatterns.csv";

    public static void main(String[] args) {
        PatternCounter counter = new PatternCounter();
        counter.run(new File(PatternExtractor.OUTPUT_FILE), new File(OUTPUT_FILE));
    }

    private void run(File inputFile, File outputFile) {
        ObjectIntOpenHashMap<String> countedPatterns = readPatterns(inputFile);
        if (countedPatterns == null) {
            return;
        }

        // sort
        LOGGER.info("Sorting " + countedPatterns.size() + " patterns...");
        String patterns[] = new String[countedPatterns.size()];
        int counts[] = new int[patterns.length];
        int count = 0;
        for (int i = 0; i < countedPatterns.allocated.length; i++) {
            if (countedPatterns.allocated[i]) {
                patterns[count] = (String) ((Object[]) countedPatterns.keys)[i];
                counts[count] = countedPatterns.values[i];
                ++count;
            }
        }
        AssociativeSort.quickSort(counts, patterns);

        writeCounts(outputFile, counts, patterns);
    }

    private ObjectIntOpenHashMap<String> readPatterns(File inputFile) {
        FileReader fReader = null;
        CSVReader cReader = null;
        ObjectIntOpenHashMap<String> countedPatterns = new ObjectIntOpenHashMap<String>();
        try {
            fReader = new FileReader(inputFile);
            cReader = new CSVReader(fReader);
            String line[] = cReader.readNext();
            int count = 0;
            while (line != null) {
                countedPatterns.putOrAdd(line[2], 1, 1);
                line = cReader.readNext();
                ++count;
                if ((count % 10000) == 0) {
                    LOGGER.info("Saw " + count + "th line.");
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception while reading patterns from file. Returning null.", e);
            return null;
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
        }
        return countedPatterns;
    }

    private void writeCounts(File outputFile, int counts[], String patterns[]) {
        FileWriter fWriter = null;
        CSVWriter cWriter = null;
        try {
            fWriter = new FileWriter(outputFile);
            cWriter = new CSVWriter(fWriter);
            String line[] = new String[2];
            for (int i = (counts.length - 1); i >= 0; --i) {
                line[0] = patterns[i];
                line[1] = Integer.toString(counts[i]);
                cWriter.writeNext(line);
            }
        } catch (Exception e) {
            LOGGER.error("Exception while writing to file. Aborting.", e);
            return;
        } finally {
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
}
