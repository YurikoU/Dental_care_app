package com.example.f21comp1011s1w5;

import com.example.f21comp1011s1w5.Utilities.DBUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class NoDentalCareController implements Initializable {

    //Chart 1: difference among the age groups
    @FXML
    private BarChart<String, Double> byAgeBarChart; //X:String, Y:Double

    @FXML
    private CategoryAxis ageGroupXAxis;

    @FXML
    private NumberAxis percentageYAxis;

    //Chart 2: changes between the research years
    @FXML
    private BarChart<Integer, Integer> byYearBarChart; //X:Integer, Y:Integer

    @FXML
    private NumberAxis numOfPeopleYAxis;

    @FXML
    private CategoryAxis researchYearXAxis;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Set the DB data into each BarChart element
        byAgeBarChart.getData().addAll(DBUtility.getPercentageByAge());
        byYearBarChart.getData().addAll(DBUtility.getChangeByResearchYear());

        //Legend area of the chart is NOT visible.
//        byAgeBarChart.setLegendVisible(false);
//        byYearBarChart.setLegendVisible(false);
    }
}
