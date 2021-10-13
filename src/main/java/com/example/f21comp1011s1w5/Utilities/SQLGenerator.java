package com.example.f21comp1011s1w5.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class SQLGenerator {

    public static void createSQL()
    {
        //create a random number generator
        SecureRandom randomNum = new SecureRandom();

        //open the formatter in the try with resources (....) block so that it will auto close
        try(
                Formatter formatter = new Formatter("noDentalCare.sql");
        )
        {
            //loop 1000 times to create random records
            for (int i = 1; i <= 1000; i++)
            {
                LocalDate dateSold = LocalDate.now().minusDays(randomNum.nextInt(1095));
                formatter.format("INSERT INTO cameraSales (cameraId, dateSold) VALUES (%d, '%s');%n",randomNum.nextInt(11)+1,dateSold);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readSqlFile()
    {
        try {
            //Read the SQL file
            Scanner scanner = new Scanner(new File("noDentalCare.sql"));

            while (scanner.hasNext())
            {
                System.out.println(scanner.nextLine());
            }

        //If there is an error
        } catch (FileNotFoundException e) {
            //Print the error on the console
            e.printStackTrace();
        }
    }

    public static void main() {
        //Execute readSqlFile() method
        readSqlFile();
    }

}
