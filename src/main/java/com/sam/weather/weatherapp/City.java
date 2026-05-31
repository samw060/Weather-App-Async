package com.sam.weather.weatherapp;


/**
 * Represents the weather data for a city.
 * Holds parsed data to update the UI.
 */
public class City {

    /** The city's name. */
    private String name;

    /** The current temperature in degrees Celsius. */
    private int temperature;

    /** The current weather condition */
    private String condition;

    /**
     * Constructs a new city given the weather data.
     * @param temperature the current temperature in degrees Celsius.
     * @param condition the current weather condition.
     */
    public City(String name, int temperature, String condition){
        this.name = name;
        this.temperature = Math.toIntExact(Math.round(temperature - 273.15));
        this.condition = condition;
    }

    // Standard JavaDoc way to do getters and setters, look back at this for reference

    /**
     * Returns the name of the city.
     *
     * @return the city's name.
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the current temperature in degrees Celsius.
     *
     * @return the temperature in degrees Celsius.
     */
    public int getTemperature(){
        return temperature;
    }

    /**
     * Returns the current condition of the weather.
     *
     * @return the condition of the weather.
     */
    public String getCondition(){
        return condition;
    }

    /**
     * Sets the name of the city.
     *
     * @param name the city's name.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the current temperature.
     *
     * @param temperature the temperature in degrees Celsius.
     */
    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    /**
     * Sets the current weather conditions.
     *
     * @param condition the condition of the weather.
     */
    public void setCondition(String condition){
        this.condition = condition;
    }
}
