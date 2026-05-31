package com.sam.weather.weatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the client class.
 */
public class ClientTests {

    Client client;
    String json;

    @BeforeEach
    void SetUp(){
        client = new Client();
        json = """
                {
                    "main": {"temp": 10},
                    "weather": [{"main": "rainy"}]
                }
                """;
    }

    @Test
    void testParseJsonReturnsCorrectTemperature(){
        City city = client.parseJson(json);
        assertEquals(10, city.getTemperature());
    }

    @Test
    void testParseJsonReturnsCorrectCondition(){
        City city = client.parseJson(json);
        assertEquals("rainy", city.getCondition());
    }

}
