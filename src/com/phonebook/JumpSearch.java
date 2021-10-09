package com.phonebook;

import java.util.ArrayList;

public class JumpSearch {
    static long jumpSearchTime;

    static void jumpSearch(ArrayList<String> directory, ArrayList<String> find) {
        System.out.println("Start searching (bubble sort - O(n^2) + jump search - O(sqrt(n))...");
        ArrayList<String> sortedDirectory = new ArrayList<>(BubbleSort.bubbleSort(directory));
        long matches = 0;
        if (BubbleSort.stopped) {
            long stoppedTimerStart = System.currentTimeMillis();
            for (String findLine : find) {
                for (String dataLine : directory) {
                    if (dataLine.contains(findLine)) {
                        matches++;
                        break;
                    }
                }
            }
            long stoppedTimerEnd = System.currentTimeMillis();
            long stopTime = stoppedTimerEnd - stoppedTimerStart;
            long stopTimeAndSortTime = BubbleSort.bubbleSortTime + stopTime;

            System.out.print("Found " + matches + " / " + find.size() + " entries. Time taken: ");
            Timer.timer(stopTimeAndSortTime);
            System.out.println();
            System.out.print("Sorting time: ");
            Timer.timer(BubbleSort.bubbleSortTime);
            System.out.println(" - STOPPED, moved to linear search");
            System.out.print("Searching time:");
            Timer.timer(stopTime);
            System.out.println();

        } else {

            long jumpSearchStart = System.currentTimeMillis();
            for (String findLine : find) {
                int blockSize = (int) Math.floor(Math.sqrt(sortedDirectory.size()));
                int currLastIndex = blockSize - 1;

                while (currLastIndex < sortedDirectory.size() &&
                        sortedDirectory.get(currLastIndex).compareTo(findLine) < 0) {
                    currLastIndex += blockSize;
                }
                for (int currSearchIndex = currLastIndex - blockSize + 1;
                     currSearchIndex <= currLastIndex && currSearchIndex < sortedDirectory.size(); currSearchIndex++) {
                    if (findLine.equals(sortedDirectory.get(currSearchIndex))) {
                        matches++;
                    }
                }
            }
            long jumpSearchEnd = System.currentTimeMillis();
            jumpSearchTime = jumpSearchEnd - jumpSearchStart;
            long jumpSearchAndSortTime = jumpSearchTime + BubbleSort.bubbleSortTime;

            System.out.print("Found " + matches + " / " + find.size() + " entries. Time taken:");
            Timer.timer(jumpSearchAndSortTime);
            System.out.println();
            System.out.print("Sorting time:");
            Timer.timer(BubbleSort.bubbleSortTime);
            System.out.println();
            System.out.print("Searching time:");
            Timer.timer(jumpSearchTime);
            System.out.println();
        }
    }
}
