package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <b>AnalyticsCounter is a Class which allow transform to make a text output from a Map object
 * </b>
 * <p>
 * <b>Note : </b>Ex :  will display the symptoms with their number of occurrence in a text file result.out
 * </p>
 *
 * @author Karl Gavillot
 * @version 2.0
 * @see AnalyticsCounter
 * @since 2022
 */
public class AnalyticsWriter extends AnalyticsCounter {

    /**
     * Constructor uses the keyword 'super' to inherit from its mother'Constructor
     * Forces to define a file when creating an instance of this child Class
     *
     * @param file (ex: symptoms.txt)
     * @see AnalyticsReader
     * @see AnalyticsCounter
     */
    public AnalyticsWriter(File file) {
        super(file);
    }

    /**
     * <p>The method counterSymptoms() used an object map to export it as a text file
     * </p>
     *
     * @return a text file result.out
     * @see AnalyticsCounter
     */
    public void symptomsWriter() {
        AnalyticsCounter symptoms = new AnalyticsCounter(file); // We obtain an instance of the Class AnalyticsCounter call 'symptoms'
        HashMap<String, Integer> wordMap = symptoms.counterSymptoms(); // Launch method from it's instance to store Map return that contain words with their occurences
        TreeMap<String, Integer> tMap = symptoms.sortSymptoms(); // Launch method from it's instance to store TreeMap to have the keys words in alphabetical order
        int symptomsTotal = 0; // Initialize a variable that will contain the total number of symptoms
        try { // when we close the writer some exceptions can occur, good practice to surround it with try catch blocks
            // next generate output
            FileWriter writer = new FileWriter("result.out"); //  Instance of FileWriter
            for (Map.Entry<String, Integer> entry : tMap.entrySet()) { // entrySet() method to iterate through a Map
                writer.write(entry.getKey() + " = " + entry.getValue() + "\n"); // write from TreeMap's Keys/Values elements into the output file
                symptomsTotal += entry.getValue(); // counts the total number of occurrences and store them
            }
            writer.write("Symptoms variations= " + tMap.size() + " Total of symptoms = " + symptomsTotal); // Displays the total number of symptom differences and the total number of occurrences
            writer.close(); // closes the writing on the file "result.out"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
