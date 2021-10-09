package com.phonebook;

import java.util.ArrayList;

public class QuickSort {
    static long quickSortTime;

    static ArrayList<String> quickSort(ArrayList<String> directory) {
        long quickSortStart = System.currentTimeMillis();
        if (directory.size() <= 1) {
            return directory; // Already sorted
        }

        ArrayList<String> sorted = new ArrayList<>();
        ArrayList<String> lesser = new ArrayList<>();
        ArrayList<String> greater = new ArrayList<>();
        String pivot = directory.get(directory.size() - 1); //Use last entry as pivot

        for (int i = 0; i < directory.size() - 1; i++) {
            if (directory.get(i).compareTo(pivot) < 0) {
                lesser.add(directory.get(i));
            } else {
                greater.add(directory.get(i));
            }
        }
        lesser = quickSort(lesser);
        greater = quickSort(greater);

        lesser.add(pivot);
        lesser.addAll(greater);
        sorted = lesser;
        long quickSortEnd = System.currentTimeMillis();
        quickSortTime = quickSortEnd - quickSortStart;

        return sorted;
    }
}
