package com.sam.weather.weatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests that the cache isolated behaviour works.
 */
public class WeatherCacheTests {
    WeatherCache cache;
    City london = new City("London", 190, "rainy");

    @BeforeEach
    void setUp(){
        cache = new WeatherCache();
        cache.put("London", london);
    }

    @Test
    void testPut(){
        City shef = new City("Sheffield", 180, "rainy");
        cache.put("Sheffield", shef);
        assertEquals(shef, cache.get("Sheffield"));
    }

    @Test
    void testGet(){
        assertEquals(london, cache.get("London"));
    }
}
