package com.phonebook;

import java.util.ArrayList;
import java.util.Hashtable;

public class HashTable {

    static void hashTable(ArrayList<String> find) {
        System.out.println("Start searching (hash table - O(1))...");
        Hashtable<Integer, String> hashDirectory = new Hashtable<>();
        long matches = 0;
        int i = 0;

        long hashTimeStart = System.currentTimeMillis();
        for (String dataLine : SetDirectory.directory) {
            hashDirectory.put(i, dataLine);
            i++;
        }
        long hashTimeEnd = System.currentTimeMillis();

        long hashSearchStart = System.currentTimeMillis();
        for (String findLine : SetDirectory.find) {
            if (hashDirectory.contains(findLine)) {
                matches++;
            }
        }
        long hashSearchEnd = System.currentTimeMillis();

        long hashTime = hashTimeEnd - hashTimeStart;
        long hashSearch = hashSearchEnd - hashSearchStart;

        System.out.print("Found " + matches + " / " + find.size() + " entries. Time taken:");
        Timer.timer(hashSearch + hashTime);
        System.out.println();
        System.out.print("Creating time:");
        Timer.timer(hashTime);
        System.out.println();
        System.out.print("Searching time:");
        Timer.timer(hashSearch);
        System.out.println();
    }
}
