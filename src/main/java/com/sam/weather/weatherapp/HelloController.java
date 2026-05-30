package com.sam.weather.weatherapp;

import com.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.http.HttpClient;

public class HelloController {

    Client client = new Client();

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
        String inputCity = cityTextBox.getText();
        cityTextBox.setText("Searching...");
        City weather = client.getCityWeather(inputCity);

        city.setText(inputCity);
        temperature.setText(String.valueOf(weather.temperature));
        condition.setText(weather.condition);
    }


}