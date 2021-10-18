package com.example.f21comp1011s1w5;

import com.example.Utilities.DbConnector;
import com.example.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
        this.byYearLineChart.setLegendVisible(false);

        this.numOfPeopleYAxis.setAutoRanging(false);

        //Connect MySQL server and set the DB data into each BarChart element
        this.byYearLineChart.getData().addAll(DbConnector.getSecondChart());

    }



    @FXML
    private void InsertANewDataButton(ActionEvent event)
    {
        try {
            SceneChanger.change(event, "insert-data-view.fxml", "Dental Health");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
