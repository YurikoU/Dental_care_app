package com.example.f21comp1011s1w5;

import com.example.f21comp1011s1w5.Utilities.DBConnector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

//Chart 2: changes between the research years
public class ByYearBarChartViewController implements Initializable {

    @FXML
    private BarChart<String, Double> byYearBarChart;

    @FXML
    private Label byYearBarChartLabel;

    @FXML
    private NumberAxis numOfPeopleYAxis;

    @FXML
    private CategoryAxis researchYearXAxis;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Legend area of the chart is NOT visible.
        byYearBarChart.setLegendVisible(false);

        //Connect MySQL server and set the DB data into each BarChart element
        byYearBarChart.getData().addAll(DBConnector.getSecondChart());

    }
}
