package com.example.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SQLGenerator {
    public static void readFile()
    {
        try {
            Scanner scn = new Scanner(new File("dataToInsertIntoTable.sql"));
            while (scn.hasNext())
            {
//                System.out.println(scn.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile();
    }

}
