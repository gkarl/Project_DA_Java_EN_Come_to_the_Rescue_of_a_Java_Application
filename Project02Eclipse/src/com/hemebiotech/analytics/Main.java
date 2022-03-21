package com.hemebiotech.analytics;

import java.io.File;

public class Main {

    public static void main(String args[]) {
        AnalyticsWriter write = new AnalyticsWriter(new File("symptoms.txt"));
        write.symptomsWriter();
    }
}
