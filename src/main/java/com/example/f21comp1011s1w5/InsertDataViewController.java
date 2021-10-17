package com.example.f21comp1011s1w5;

import com.example.DbConection.Inserter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class InsertDataViewController implements Initializable {


    @FXML
    private ComboBox<String> ageGroupComboBox;

    @FXML
    private Label ageGroupLabel;

    @FXML
    private ComboBox<String> educationalLevelComboBox;

    @FXML
    private Label educationalLevelLabel;

    @FXML
    private RadioButton isDentalVisitRadioButton;

    @FXML
    private Tooltip isDentalVisitToolTip;

    @FXML
    private ComboBox<String> raceComboBox;

    @FXML
    private Label raceLabel;

    @FXML
    private ComboBox<Integer> researchYearComboBox;

    @FXML
    private Label researchYearLabel;

    @FXML
    private ComboBox<String> sexComboBox;

    @FXML
    private Label sexLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Declare the valid answer collections
        List<String> ageGroups = Arrays.asList(
                "Under 18 years",
                "18–24 years",
                "25–34 years",
                "35–44 years",
                "45–54 years",
                "45–54 years",
                "65 years and over");
        List<String> sex = Arrays.asList(
                "Male",
                "Female");
        List<String> races = Arrays.asList(
                "White",
                "Black",
                "American Indian or Alaska Native",
                "Asian",
                "Hispanic or Latino",
                "2 or more races");
        List<String> educationLevels = Arrays.asList(
                "No high school diploma",
                "High school diploma",
                "Some college or more");
        List<Integer> researchYears = Arrays.asList(
                1997,
                2005,
                2010,
                2018);

        //Set each list into the proper ComboBox
        ageGroupComboBox.getItems().addAll(ageGroups);
        sexComboBox.getItems().addAll(sex);
        raceComboBox.getItems().addAll(races);
        educationalLevelComboBox.getItems().addAll(educationLevels);
        researchYearComboBox.getItems().addAll(researchYears);
    }



    @FXML
    private void insertDataButton()
    {
        String ageGroup       = this.ageGroupComboBox.getSelectionModel().getSelectedItem();
        String sex            = this.sexComboBox.getSelectionModel().getSelectedItem();
        String race           = this.raceComboBox.getSelectionModel().getSelectedItem();
        String educationLevel = this.educationalLevelComboBox.getSelectionModel().getSelectedItem();
        int researchYear      = this.researchYearComboBox.getSelectionModel().getSelectedItem();
        boolean isDentalVisit = this.isDentalVisitRadioButton.isSelected();

        //SQL query
        String query = "INSERT INTO noDentalCares (ageGroup, sex, race, educationLevel, researchYear, isDentalVisit) " +
                "VALUES ('"+ageGroup+"','"+sex+"','"+race+"','"+educationLevel+"',"+researchYear+","+isDentalVisit+");";

        //Execute the query
        Inserter.insert(query);
    }

    //Show the first chart once a user clicks the button
    @FXML
    private void viewChartButton()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("by-age-bar-chart-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
            stage.setTitle("Dental Health Chart");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
