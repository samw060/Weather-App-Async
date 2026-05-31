package com.sam.weather.weatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityTests {

    City city;

    @BeforeEach
    void SetUp(){
        city = new City("Sheffield", 293, "moderate rain");
    }

    @Test
    void testGetCityName(){
        assertEquals("Sheffield", city.getName());
    }

    @Test
    void testSetCityName(){
        city.setName("London");
        assertEquals("London", city.getName());
    }

    @Test
    void testGetCityTemperature(){
        assertEquals(20, city.getTemperature());
    }

    @Test
    void testSetCityTemperature(){
        city.setTemperature(30);
        assertEquals(30, city.getTemperature());
    }

    @Test
    void testGetCityCondition(){
        assertEquals("moderate rain", city.getCondition());
    }

    @Test
    void testSetCityCondition(){
        city.setCondition("very rainy");
        assertEquals("very rainy", city.getCondition());
    }
}
