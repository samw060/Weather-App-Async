package com.sam.weather.weatherapp;

/**
 * Exception thrown when a weather API request fails.
 * Contains HTTP status code and error message.
 */
public class WeatherException extends RuntimeException {

    /** The HTTP status code of the associated error. */
    private int statusCode;

    /**
     * Constructs a new WeatherException with the error message and status code.
     *
     * @param message the description of the error.
     * @param statusCode the code related to the error.
     */
    public WeatherException(String message, int statusCode){
        super(message);                     // As a runtime-exception can take a message in constructor, super() passes it into message field.
        this.statusCode = statusCode;
    }

    /**
     * Returns the status code of the error.
     *
     * @return the status code.
     */
    public int getStatusCode(){
        return statusCode;
    }

    // Get message inherited for free.

}


