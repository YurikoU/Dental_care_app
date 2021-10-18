package com.example.f21comp1011s1w5;

import com.example.Utilities.DbConnector;
import com.example.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ByAgeBarChartViewController implements Initializable {

    //Chart 1: difference among the age groups
    @FXML
    private BarChart<String, Double> byAgeBarChart; //X:String, Y:Double

    @FXML
    private CategoryAxis ageGroupXAxis;

    @FXML
    private NumberAxis numOfPeopleByAgeYAxis;;

    @FXML
    private Label byAgeBarChartLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Legend area is NOT visible.
        byAgeBarChart.setLegendVisible(false);

        //Connect MySQL server and set the DB data into each BarChart element
        byAgeBarChart.getData().addAll(DbConnector.getFirstChart());
    }


    //Once a user clicks the button, the second chart will be displayed
    @FXML
    private void viewButton(ActionEvent event){
        try {
            SceneChanger.change(event, "by-year-bar-chart-view.fxml", "Dental Health Chart");
        } catch (Exception e){
            e.printStackTrace();
        }
    };

}
