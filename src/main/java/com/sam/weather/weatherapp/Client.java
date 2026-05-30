package com.sam.weather.weatherapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/** Represents the object that sends and recieves the GET requests to get weatherh data. */
public class Client {
    /** Creates the client to send and receive the requests */
    private HttpClient client = HttpClient.newHttpClient();

    /** The api key for openweathermap.org */
    private String apiKey = "fc6ba67fa7afd9770cc11af85e00dcaa";

    /**
     * Makes the url request we want to send in url, creates http request object with url.
     * Sets up the response object to receive from the server via the client for the request and
     * how we want to receive the data as a string in the body handler.
     * @param city is the city the user entered.
     */
    public City getCityWeather(String city){
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseJson(response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Parses the json received from the client into a city object, specifically the temperature
     * and weather condition (main).
     * @param json raw json string from client.
     * @return a city object filled with data parsed from the string.
     */
    private City parseJson(String json){
        JsonObject parsed = JsonParser.parseString(json).getAsJsonObject();
        JsonObject main = parsed.getAsJsonObject("main");
        JsonArray weather = parsed.getAsJsonArray("weather");
        return new City(main.get("temp").getAsInt(), weather.get(0).getAsJsonObject().get("main").getAsString());
    }

}
