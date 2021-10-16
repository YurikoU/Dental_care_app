package com.example.Utilities;

import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnector {
    //Database connection information
    private static String userName = "student";
    private static String password = "student";
    private static String jdbcUrl  = "jdbc:mysql://localhost:3306/javaProjects";


    //Execute the SQL query for the Chart 1
    public static XYChart.Series<String, Double> getFirstChart()
    {
        XYChart.Series<String, Double> chartObj1 = new XYChart.Series<>();

        //SQL query
        String query = "SELECT ageGroup, (COUNT(isDentalVisit) / 1258) * 100\n" +
                       "FROM noDentalCares\n" +
                       "WHERE researchYear = '2018' AND isDentalVisit = false\n" +
                       "GROUP BY ageGroup \n" +
                       "ORDER BY ageGroup ASC;";

        //use the try with resources ensure that anything opened in the ( ... ) will be closed
        try(
                //Connect to the MySQL database
                Connection conn     = DriverManager.getConnection(jdbcUrl, userName, password);
                //Execute the SQL query
                Statement statement = conn.createStatement();
                //Get the table data from the database
                ResultSet resultSet = statement.executeQuery(query);
            )
        {
            //As long as there is more SQL data
            while (resultSet.next())
            {
                //Convert the SQL result into the XYChart
                chartObj1.getData().add(
                    new XYChart.Data<>(
                            resultSet.getString("ageGroup"),//X-axis
                            resultSet.getDouble("(COUNT(isDentalVisit) / 1258) * 100")//Y-axis
                    )
                );
            }

        }catch (Exception e)
        {
            //If there is an error, print it on the console
            e.printStackTrace();
        }

        return chartObj1;
    }


    //Execute the SQL query for the Chart 2
    public static XYChart.Series<String, Double> getSecondChart()
    {
        XYChart.Series<String, Double> chartObj2 = new XYChart.Series<>();

        //SQL query
        String query = "SELECT researchYear, count(isDentalVisit)\n" +
                       "FROM noDentalCares\n" +
                       "WHERE isDentalVisit is false\n" +
                       "GROUP BY researchYear\n" +
                       "ORDER BY researchYear ASC;";

        try(
                //Connect to the MySQL database
                Connection conn     = DriverManager.getConnection(jdbcUrl, userName, password);
                //Execute the query
                Statement statement = conn.createStatement();
                //Get the table data from the database
                ResultSet resultSet = statement.executeQuery(query);
            )
        {
//            System.out.println("connected");

            //As long as there is more SQL data
            while (resultSet.next())
            {
                //Convert the SQL result into the XYChart
                chartObj2.getData().add(
                    new XYChart.Data<>(
                        resultSet.getString("researchYear"),//X-axis
                        resultSet.getDouble("COUNT(isDentalVisit)")//Y-axis
                    )
                );
            }

        //If there is an error
        }catch (Exception e)
        {
            //Print the error on the console
            e.printStackTrace();
        }
        return chartObj2;
    }


}