package com.hemebiotech.analytics;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Main {

    /**
     * Method main() entry point of the program
     * The user get the distinct symptoms and the number of occurrences of each of these symptoms in output file name result.out
     *
     * @param args File("symptoms.txt")
     * @author Karl Gavillot
     * @version 2.0
     * @see AnalyticsWriter
     */
    public static void main(String args[]) {

        AnalyticsReader read = new AnalyticsReader(new File("symptoms.txt"));
        List<String> wordList = read.getSymptoms();

        AnalyticsCounter count = new AnalyticsCounter();
        HashMap<String, Integer> wordMap = count.counterSymptoms(wordList);
        TreeMap<String, Integer> tMap = count.sortSymptoms(wordMap);

        AnalyticsWriter write = new AnalyticsWriter();
        write.symptomsWriter(tMap);
    }
}
