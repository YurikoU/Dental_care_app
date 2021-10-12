module com.example.f21comp1011s1w5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.f21comp1011s1w5 to javafx.fxml;
    exports com.example.f21comp1011s1w5;
}