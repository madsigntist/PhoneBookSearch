package com.phonebook;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    static long binarySearchTime;

    static void binarySearch(ArrayList<String> directory, ArrayList<String> find) {
        System.out.println("Start searching (quick sort - O(n*log(n)) + binary search - O(log n))...");
        long binaryStart = System.currentTimeMillis();
        ArrayList<String> sortedDirectory = QuickSort.quickSort(directory);
        long matches = 0;

        for (String findLine : find) {
            if (Collections.binarySearch(sortedDirectory, findLine) > 0) {
                matches++;
            }
        }
        long binaryEnd = System.currentTimeMillis();
        binarySearchTime = binaryEnd - binaryStart;
        long quickBinaryTime = QuickSort.quickSortTime + binarySearchTime;

        System.out.print("Found " + matches + " / " + find.size() + " entries. Time taken:");
        Timer.timer(quickBinaryTime);
        System.out.println();
        System.out.print("Sorting time:");
        Timer.timer(QuickSort.quickSortTime);
        System.out.println();
        System.out.print("Searching time:");
        Timer.timer(binarySearchTime);
        System.out.println();
    }
}
