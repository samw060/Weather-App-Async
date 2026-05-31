package com.sam.weather.weatherapp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Now this is being made to work with async http requests so that the UI doesn't free while waiting for api requests.
 *
 */

public class WeatherController {
    /**
     * Creates the client object we need to send and receive data.
     */
    Client client = new Client();

    DatabaseManager manager = new DatabaseManager();

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
     * Gets the city input from the text field entered by user, sets textbox to searching and disable button to stop more searches.
     * now need to finish handling the clients async call we made earlier to update the UI, as you cannot return the values from the
     * async request.
     * It updates all the relevant fields and the text box and re-enables the button if request is successful.
     * If unsuccessful, the UI updates with the exception to show the city not found.
     */
    @FXML
    private void searchWeather(){
        String inputCity = cityTextBox.getText();
        cityTextBox.setPromptText("Searching...");
        searchButton.setDisable(true);

        client.getCityWeather(inputCity)
                .thenAccept(cityData -> {
                    Platform.runLater(() ->{
                        city.setText(inputCity);
                        temperature.setText(String.valueOf(cityData.getTemperature()));
                        condition.setText(cityData.getCondition());
                        cityTextBox.clear();
                        cityTextBox.setPromptText("Enter city name...");
                        searchButton.setDisable(false);
                    });

                    manager.addEntry(cityData);

                })
                .exceptionally(e ->{
                    WeatherException we = (WeatherException) e.getCause(); // casts the error into a weather exception
                    Platform.runLater(() -> {
                        city.setText(we.getMessage());
                        temperature.setText("0");
                        condition.setText("");
                        cityTextBox.setPromptText("Enter city name...");
                        searchButton.setDisable(false);
                    });
                    return null;
                });


    }


}