package com.example.DbConection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataInserter {

    //Database connection information
    private static String userName = "student";
    private static String password = "student";
    private static String jdbcUrl  = "jdbc:mysql://localhost:3306/javaProjects";

    public static void insert(String query)
    {
        try
        {
            //Connect to the MySQL database
            Connection conn     = DriverManager.getConnection(jdbcUrl, userName, password);
            //Prepare the query
            Statement statement = conn.createStatement();
            //Execute the query
            statement.executeUpdate(query);
            //Close the DB connection
            conn.close();
        }catch (Exception e)
        {
            //If there is an error, print it on the console
            e.printStackTrace();
        }
    }
}
