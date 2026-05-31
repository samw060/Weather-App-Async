package com.sam.weather.weatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the weather exception class.
 */
public class WeatherExceptionTests {

    WeatherException exception;

    @BeforeEach
    void SetUp(){
        exception = new WeatherException("City not found", 404);
    }

    @Test
    void testExceptionMessage(){
        assertEquals("City not found", exception.getMessage());
    }

    @Test
    void testExceptionStatusCode(){
        assertEquals(404, exception.getStatusCode());
    }

    @Test
    void isRunTimeException(){
        assertInstanceOf(RuntimeException.class, exception);
    }
}
