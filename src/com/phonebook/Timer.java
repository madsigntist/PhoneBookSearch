package com.phonebook;

public class Timer {
    static void timer(long time) {
        long min = time / 1000 / 60;
        long sec = time / 1000 % 60;
        long ms = time - sec * 1000;
        System.out.print(" " + min + " min. " + sec + " sec. " + ms + " ms. ");
    }
}
