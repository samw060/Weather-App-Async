package com.sam.weather.weatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the client class.
 */
public class DatabaseManagerTests {
    DatabaseManager db;
    @BeforeEach
    void setUp(){
        db = new DatabaseManager("jdbc:sqlite::memory:");
    }

    //Cannot write tests without being able to access the table through DatabaseManager class.

}
