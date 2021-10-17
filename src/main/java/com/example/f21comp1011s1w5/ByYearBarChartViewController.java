package com.example.f21comp1011s1w5;

import com.example.DbUtilities.DbConnector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

//Chart 2: changes between the research years
public class ByYearBarChartViewController implements Initializable {

    @FXML
    private Label byYearLineChartLabel;

    @FXML
    private NumberAxis numOfPeopleYAxis;

    @FXML
    private CategoryAxis researchYearXAxis;

    @FXML
    private LineChart<String, Double> byYearLineChart;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Legend area is NOT visible.
        byYearLineChart.setLegendVisible(false);

        //Connect MySQL server and set the DB data into each BarChart element
        byYearLineChart.getData().addAll(DbConnector.getSecondChart());

    }
}
