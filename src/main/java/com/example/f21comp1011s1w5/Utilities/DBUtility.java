package com.example.f21comp1011s1w5.Utilities;

import com.example.f21comp1011s1w5.NoDentalCare;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
    //Database connection information
    private static String userName   = "student";
    private static String password   = "student";
    private static String connectUrl = "jdbc:mysql://localhost:3306/javaProjects";

    public static XYChart.Series<String, Integer> getPercentageByAge()
    {
        XYChart.Series<String, Integer> dataFromChart = new XYChart.Series<>();

        //SQL query
        String query = "SELECT ageGroup, (COUNT(isDentalVisit) / 1258) * 100 AS \"People who COUNLDN'T visited in 2018 (%)\"\n" +
                       "FROM noDentalCares\n" +
                       "WHERE researchYear = '2018' AND isDentalVisit = false\n" +
                       "GROUP BY ageGroup \n" +
                       "ORDER BY ageGroup ASC;";

        //use the try with resources ensure that anything opened in the ( ... ) will be closed
        try(
                //Connect to the MySQL database
                Connection conn     = DriverManager.getConnection(connectUrl, userName, password);
                //Execute the query
                Statement statement = conn.createStatement();
                //Get the result
                ResultSet resultSet = statement.executeQuery(query);
            )
        {
            //Run until the end of the rows of the SQL table
            while (resultSet.next())
            {
                dataFromChart.getData().add(new XYChart.Data<>(resultSet.getString("camera"), resultSet.getInt("Units Sold")));
            }

        //If there is an error
        }catch (Exception e)
        {
            //Print the error on the console
            e.printStackTrace();
        }

        return dataFromChart;
    }


    public static ArrayList<NoDentalCare> getChangeByResearchYear()
    {
        ArrayList<NoDentalCare> ndcObjects = new ArrayList<>();

        //SQL query
        String query = "SELECT researchYear, count(isDentalVisit) AS \"Number of people who COUNLDN'T visit in each year\"\n" +
                       "FROM noDentalCares\n" +
                       "WHERE isDentalVisit = false\n" +
                       "GROUP BY researchYear\n" +
                       "ORDER BY researchYear ASC;";

        //use the try with resources ensure that anything opened in the ( ... ) will be closed
        try(
                //Connect to the MySQL database
                Connection conn     = DriverManager.getConnection(connectUrl, userName, password);
                //Execute the query
                Statement statement = conn.createStatement();
                //Get the result
                ResultSet resultSet = statement.executeQuery(query);
            )
        {
            while (resultSet.next())
            {
                int noDentalCaresId    = resultSet.getInt("noDentalCaresId");
                String ageGroup        = resultSet.getString("ageGroup");
                String sex             = resultSet.getString("sex");
                String race            = resultSet.getString("race");
                String educationLevel  = resultSet.getString("educationLevel");
                int researchYear       = resultSet.getInt("researchYear");
                Boolean isDentalVisit  = resultSet.getBoolean("isDentalVisit");

                NoDentalCare ndcObject = new NoDentalCare(ageGroup,sex,race,educationLevel,researchYear,isDentalVisit);
                ndcObject.setNoDentalCaresId(noDentalCaresId);

                ndcObjects.add(ndcObject);
            }

        //If there is an error
        }catch (Exception e)
        {
            //Print the error on the console
            e.printStackTrace();
        }
        return ndcObjects;
    }
}