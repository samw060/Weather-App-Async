package com.sam.weather.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WeatherController {
    /**
     * Creates the client object we need to send and receive data.
     */
    Client client = new Client();

    /**
     * Text box the user enters the name of the city into.
     */
    @FXML
    private TextField cityTextBox;

    /**
     * Button which calls searchWeather() to get the data and update labels.
     */
    @FXML
    private Button searchButton;

    /**
     * Name of the city.
     */
    @FXML
    private Label city;
    /**
     * Shows the temperature.
     */
    @FXML
    private Label temperature;

    /**
     * Shows the weather condition.
     */
    @FXML
    private Label condition;

    /**
     * Gets the city input from the text field entered by user, updates the text field while searching
     * gets the info from the client and creates a new city object, then sets the labels with the
     * respective info.
     */
    @FXML
    private void searchWeather(){
        String inputCity = cityTextBox.getText();
        cityTextBox.setPromptText("Searching...");
        City weather = client.getCityWeather(inputCity);

        cityTextBox.setText("");
        cityTextBox.setPromptText("Enter new city");
        city.setText(inputCity);
        temperature.setText(String.valueOf(weather.getTemperature()));
        condition.setText(weather.getCondition());
    }


}