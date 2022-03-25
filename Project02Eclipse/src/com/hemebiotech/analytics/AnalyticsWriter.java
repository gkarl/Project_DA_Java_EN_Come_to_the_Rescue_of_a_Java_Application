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

    private Object HashMap;

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
     * @return a text file result.out which contains the distinct symptoms and the number of occurrences of each of these symptoms
     * @see AnalyticsCounter
     */
    public File symptomsWriter() {

        HashMap<String, Integer> wordMap = this.counterSymptoms(); // with inheritance we get the return of the counterSymptoms() method from the AnalyticsCounter mother class and we store it in a variable
        TreeMap<String, Integer> tMap = this.sortSymptoms(wordMap); // with inheritance we get the return of the sortSymptoms() method from the AnalyticsCounter mother class and we store it in a variable
        int symptomsTotal = 0; // Initialize a variable that will contain the total number of symptoms
        try { // when we close the writer some exceptions can occur, good practice to surround it with try catch blocks
            // next generate output
            File file = new File("result.out");
            FileWriter writer = new FileWriter(file); //  Instance of FileWriter
            for (Map.Entry<String, Integer> entry : tMap.entrySet()) { // entrySet() method to iterate through a Map
                writer.write(entry.getKey() + " = " + entry.getValue() + "\n"); // write from TreeMap's Keys/Values elements into the output file
                symptomsTotal += entry.getValue(); // counts the total number of occurrences and store them
            }
            writer.write("Symptoms variations= " + tMap.size() + " Total of symptoms = " + symptomsTotal); // Displays the total number of symptom differences and the total number of occurrences
            writer.close(); // closes the writing on the file "result.out"
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
