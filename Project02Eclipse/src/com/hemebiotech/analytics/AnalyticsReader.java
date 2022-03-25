package com.hemebiotech.analytics;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>AnalyticsCounter is a Class which takes a .txt file and transforms it into a list collection object.
 * </b>
 * <p>
 * <b>Note : </b>ex symptoms.txt, each symptom becomes an element of the created list
 * </p>
 *
 * @author Karl Gavillot
 * @version 2.0
 * @since 2022
 */
public class AnalyticsReader implements ISymptomReader {

    /**
     * File attribute that must be defined by user to be processed by the Java program
     */
    public File file;

    /**
     * Constructor which imposes when an instance of the AnalyticsReader class is created
     * to define a file to be used by the program
     *
     * @param file it is necessary to define at the creation of the AnalyticsReader object the file that will be processed
     */
    public AnalyticsReader(File file) {
        this.file = file;
    }

    /**
     * <p>The method getSymptoms() used to transform a text file into a list object
     * </p>
     *
     * @return return a List object which contains the list of all symptom words contained in the text file entered by user here symptoms.txt
     * @see AnalyticsReader
     */
    public List<String> getSymptoms() {
        List<String> wordsList = new ArrayList<>(); // Instantiates a List of String
        BufferedReader reader = null;  // BufferedReader will help to read file .txt
        try { // exceptions may occur with BufferedReader good practice to surround it with try catch blocks
            // first get input
            reader = new BufferedReader(new FileReader(this.file)); // BufferedReader has in its the Class FileReader
            String line = reader.readLine(); // Read the file .txt line by line and store it in a String variable
            while (line != null) { // As long as we have text on the line
                String words[] = line.toLowerCase().split(" "); // allows to remove spaces to keep only lowercase words stored in an array
                for (int i = 0; i < words.length; i++) { // Iteration to read one by one the words contained in the Array
                    wordsList.add(words[i]); // add one by one the words in a List
                    //System.out.println(words[i]);
                }
                line = reader.readLine(); // get another line (ex symptom)
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) { // Good idea to add a catch block if exceptions occur with the methode readLine()
            e.printStackTrace();
        } finally {
            try { // when we close the reader some exceptions can occur, good practice to surround it with try catch blocks
                reader.close(); // Once the reading of .txt is finished we close the reading flow with this file
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wordsList; // Method return the created List
    }
}





