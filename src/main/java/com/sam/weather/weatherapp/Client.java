package com.sam.weather.weatherapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/** Represents the object that sends and receives the GET requests to get weather data. */
public class Client {
    /** Creates the client to send and receive the requests */
    private HttpClient client = HttpClient.newHttpClient();

    /** The api key for openweathermap.org */
    private String apiKey = "fc6ba67fa7afd9770cc11af85e00dcaa";

    /**
     * Makes the url request we want to send in url, creates http request object with url.
     * Then makes an async api request with the request and how we want the body of the response to be (String).
     * We use "thenApply" to change the data into the format we want to use, get the body then parse it,
     * this is then returned to the searchWeather function in WeatherController to update the UI, if
     * an error is thrown it then returns a failed future to tell the UI it hasn't worked.
     *
     * List of different status codes meaning:
     * 404 - Resource not found, which is why city is not found.
     * 401 - Unauthorized, which is due to the API key being invalid.
     * 429 - Too many requests.
     * !200 - Any other error which isn't "OK" (200).
     *
     * @param city is the city the user entered.
     * @return the city object to be completed in the future due to async call or null if there's an error.
     */
    public CompletableFuture<City> getCityWeather(String city){
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(response -> {
                        if (response.statusCode() == 404) {
                            throw new WeatherException("City not found", 404);
                        }else if (response.statusCode() == 401){
                            throw new WeatherException("Invalid API key", 401);
                        }else if (response.statusCode() == 429){
                            throw new WeatherException("Too many requests, please wait", 429);
                        }else if (response.statusCode() != 200){
                            throw new WeatherException("Server error", response.statusCode());
                        }
                        return response.body();
                    })
                    .thenApply(this::parseJson);
        } catch (Exception e) {
            return CompletableFuture.failedFuture(new WeatherException(e.getMessage(), 0));
        }
    }

    /**
     * Parses the json received from the client into a city object, specifically the temperature
     * and weather condition (main).
     * @param json raw json string from client.
     * @return a city object filled with data parsed from the string.
     */
    City parseJson(String json){
        JsonObject parsed = JsonParser.parseString(json).getAsJsonObject();
        JsonObject main = parsed.getAsJsonObject("main");
        JsonArray weather = parsed.getAsJsonArray("weather");
        return new City(main.get("temp").getAsInt(), weather.get(0).getAsJsonObject().get("main").getAsString());
    }

}
