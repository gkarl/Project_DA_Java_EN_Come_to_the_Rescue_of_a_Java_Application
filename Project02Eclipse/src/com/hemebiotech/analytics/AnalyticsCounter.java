package com.hemebiotech.analytics;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;


/**
 * <b>AnalyticsCounter is a Class which allow an application to convert a list of string
 * (ex symptoms) and counts their occurrences and sorts them alphabetically.</b>
 * <p>
 * <b>Note : </b>This Class was the subject of a correction to a previous development
 * </p>
 *
 * @author Karl Gavillot
 * @version 2.0
 * @see AnalyticsReader
 * @since 2022
 */
public class AnalyticsCounter extends AnalyticsReader {

    HashMap<String, Integer> wordMap = new HashMap<>();
    TreeMap<String, Integer> triMap = new TreeMap<>();

    /**
     * Constructor uses the keyword 'super' to inherit from its mother'Constructor
     * Forces to define a file when creating an instance of this child Class
     *
     * @param file (ex: symptoms.txt)
     * @see AnalyticsReader
     */
    public AnalyticsCounter(File file) {
        super(file);
    }

    /**
     * <p>The method counterSymptoms() used to create the Map from a list (ex symptoms)
     * and count the number of occurrences
     * </p>
     *
     * @return Hashmap which Key Value corresponding to the symptoms with their number of occurrences
     * @see AnalyticsReader
     */
    public HashMap<String, Integer> counterSymptoms() {
        AnalyticsReader symptoms = new AnalyticsReader(this.file); // We obtain an instance of the Class AnalyticsReader
        List<String> wordList = symptoms.getSymptoms(); // Launch the method to read the file with this instance and stock the return
        for (String word : wordList) { // Iterate on the word list
            if (wordMap.containsKey(word)) { // If a word in the list corresponds to a key in the map
                wordMap.put(word, wordMap.get(word) + 1);  // '.get' allows to find this word in the Map then add 1 to the Map's value
            } else { // If this word on which we iterate is not found in the Map
                wordMap.put(word, 1); // We add the word to the Map with the value 1
            }
        }
        //wordMap.forEach((k,v) -> System.out.println(k + " : " + v));
        return wordMap; // Method return the created Map
    }

    /**
     * <p>
     * The method sortSymptoms() used to sort the symptoms
     * and their number of occurrences in alphabetical order
     * </p>
     *
     * @return Treemap key value, corresponds to each symptoms with their number of occurrence sorted in alphabetical order
     */
    public TreeMap<String, Integer> sortSymptoms() {
        triMap.putAll(wordMap); // puts all the key value elements of the map in a TreeMap which sorts the keys (words) alphabetically automatically
        triMap.forEach((k, v) -> System.out.println(k + " : " + v)); // Use lambda to iterate on the TreeMap and display in the console its key (symptoms) value (occurences)
        return triMap; // Method return the created TreeMap
    }


}
