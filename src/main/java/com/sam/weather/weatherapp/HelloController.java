package com.sam.weather.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    String apiKey;



    @FXML
    private TextField cityTextBox;

    @FXML
    private Button searchButton;

    @FXML
    private Label city;

    @FXML
    private Label temperature;

    @FXML
    private Label condition;

    @FXML
    private void searchWeather(){
        String city = cityTextBox.getText();
        cityTextBox.setText("Searching...");
    }
}