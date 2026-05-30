package com.sam.weather.weatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityTests {

    City city;

    @BeforeEach
    void SetUp(){
        city = new City(20, "moderate rain");
    }

    @Test
    void testCityTemperatureGetter(){
        assertEquals(20, city.getTemperature());
    }

    @Test
    void testCityTemperatureSetter(){
        city.setTemperature(30);
        assertEquals(30, city.getTemperature());
    }

    @Test
    void testCityConditionGetter(){
        assertEquals("moderate rain", city.getCondition());
    }

    @Test
    void testCityConditionSetter(){
        city.setCondition("very rainy");
        assertEquals("very rainy", city.getCondition());
    }
}
