package com.phonebook;

public class LinearSearch {
    static long linearSearchTime;

    static void linearSearch() {
        System.out.println("Start searching (linear search - O(n))...");

        long startTime = System.currentTimeMillis();
        long numMatches = 0;
        for (String findLine : SetDirectory.find) {
            for (String dataLine : SetDirectory.directory) {
                if (dataLine.contains(findLine)) {
                    numMatches++;
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        linearSearchTime = endTime - startTime;

        System.out.print("Found " + numMatches + " / " + SetDirectory.find.size() + " entries. Time taken:");
        Timer.timer(linearSearchTime);
        System.out.println();
    }
}
