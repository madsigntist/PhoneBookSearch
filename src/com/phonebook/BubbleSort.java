package com.phonebook;

import java.util.ArrayList;

public class BubbleSort {
    static long bubbleSortTime;
    static boolean stopped;

    static ArrayList<String> bubbleSort(ArrayList<String> directory) {
        String temp;
        boolean sorted = false;
        stopped = false;

        long sortedTimerStart = System.currentTimeMillis();
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < directory.size() - 1; i++) {
                if (directory.get(i).compareTo(directory.get(i + 1)) > 0) {
                    temp = directory.get(i);
                    directory.set(i, directory.get(i + 1));
                    directory.set(i + 1, temp);
                    sorted = false;
                }
            }


            if (System.currentTimeMillis() - sortedTimerStart >= LinearSearch.linearSearchTime * 10) {
                stopped = true;
                long sortedTimerStopped = System.currentTimeMillis();
                bubbleSortTime = sortedTimerStopped - sortedTimerStart;
                return directory;
            }
        }
        long sortedTimerEnd = System.currentTimeMillis();
        bubbleSortTime = sortedTimerEnd - sortedTimerStart;

        return directory;
    }
}
