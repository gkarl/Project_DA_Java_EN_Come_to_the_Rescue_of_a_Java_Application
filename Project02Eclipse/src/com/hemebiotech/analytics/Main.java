package com.hemebiotech.analytics;

import java.io.File;

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
        AnalyticsWriter write = new AnalyticsWriter(new File("symptoms.txt"));
        write.symptomsWriter();
    }
}
