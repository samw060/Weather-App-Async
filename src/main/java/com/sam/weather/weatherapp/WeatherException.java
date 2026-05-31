package com.sam.weather.weatherapp;

/**
 * This class is how I handle the different error codes I can get from the HTTP request.
 * It extends runtime-exception as this is an unchecked exception it will only be seen at run time
 * so we don't need to wrap it in try catch, or write throws throughout the code.
 */
public class WeatherException extends RuntimeException {

    private int statusCode;

    public WeatherException(String message, int statusCode){
        super(message);                     // As a runtime-exception can take a message in constructor, super() passes it into message field.
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return statusCode;
    }

    // Get message inherited for free.

}


