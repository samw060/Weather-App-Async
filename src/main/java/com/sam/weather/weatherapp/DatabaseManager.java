package com.sam.weather.weatherapp;

import java.sql.*;

public class DatabaseManager {
    private String URL = "jdbc:sqlite:weather.db";
    private Connection connection;

    public DatabaseManager(){
        connect();
        createTable();
    }

    public DatabaseManager(String URL){
        this.URL = URL;
        connect();
        createTable();
    }

    private void connect(){
        try{
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Could not connect to database",e);
        }
    }

    private void createTable(){
        String sql = """
                CREATE TABLE IF NOT EXISTS search_history(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    city TEXT NOT NULL,
                    searched_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Could not create table", e);
        }
    }

    public void addEntry(City city){
        String sql = """
                INSERT INTO search_history(city)
                VALUES(?)
                """;
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, city.getName());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Could not add to database", e);
        }
    }

}
