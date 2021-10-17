package com.example.f21comp1011s1w5;

import com.example.DbUtilities.DbConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    @FXML
    private TextArea msgTextArea;

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
        this.ageGroupComboBox.getItems().addAll(ageGroups);
        this.sexComboBox.getItems().addAll(sex);
        this.raceComboBox.getItems().addAll(races);
        this.educationalLevelComboBox.getItems().addAll(educationLevels);
        this.researchYearComboBox.getItems().addAll(researchYears);
    }


    //Create and insert a new data into SQL table once a user clicks the button
    @FXML
    private void insertDataButton()
    {
        String ageGroup       = this.ageGroupComboBox.getSelectionModel().getSelectedItem();
        String sex            = this.sexComboBox.getSelectionModel().getSelectedItem();
        String race           = this.raceComboBox.getSelectionModel().getSelectedItem();
        String educationLevel = this.educationalLevelComboBox.getSelectionModel().getSelectedItem();
        int researchYear      = this.researchYearComboBox.getSelectionModel().getSelectedItem();
        boolean isDentalVisit = this.isDentalVisitRadioButton.isSelected();

        //Create a object from the entered values based on the model
        NoDentalCare noDentalCareObj = new NoDentalCare(ageGroup, sex, race, educationLevel, researchYear, isDentalVisit);
        this.msgTextArea.setWrapText(true);
        this.msgTextArea.setText("Your New Data\n" + noDentalCareObj);

        try
        {

            //SQL query to run
            String query = "INSERT INTO noDentalCares (ageGroup, sex, race, educationLevel, researchYear, isDentalVisit) " +
                            "VALUES ('"+ageGroup+"','"+sex+"','"+race+"','"+educationLevel+"',"+researchYear+","+isDentalVisit+");";
            //Execute the query
            DbConnector.insert(query);

        } catch (Exception e)
        {
            this.msgTextArea.setText(e.getMessage());
            this.msgTextArea.setWrapText(true);
            this.msgTextArea.setStyle(
                    "-fx-text-fill: red; " +
                    "-fx-font-size: 12px; " +
                    "-fx-font-weight: bold;");
        }
    }

    //Show the first chart once a user clicks the button
    @FXML
    private void backToTheChartButton()
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
