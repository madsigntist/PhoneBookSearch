package com.phonebook;

public class Main {

    public static void main(String[] args) {
        SetDirectory.setDirectory();
        LinearSearch.linearSearch();
        System.out.println();
        JumpSearch.jumpSearch(SetDirectory.directory, SetDirectory.find);
        System.out.println();
        BinarySearch.binarySearch(SetDirectory.directory, SetDirectory.find);
        System.out.println();
        HashTable.hashTable(SetDirectory.find);
    }
}