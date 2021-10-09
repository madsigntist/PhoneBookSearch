package com.phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SetDirectory {
    static ArrayList<String> directory = new ArrayList<>();
    static ArrayList<String> find = new ArrayList<>();

    public static void setDirectory() {
        try (Scanner fs1 = new Scanner(new File("small_directory.txt"));
             Scanner fs2 = new Scanner(new File("small_find.txt"))) {
            while (fs1.hasNextLine())
                directory.add(fs1.nextLine());
            while (fs2.hasNextLine())
                find.add(fs2.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }
        for (int i = 0; i < directory.size(); i++) {
            directory.set(i, directory.get(i).replaceAll("[0-9]+ ", ""));
        }
    }
}
