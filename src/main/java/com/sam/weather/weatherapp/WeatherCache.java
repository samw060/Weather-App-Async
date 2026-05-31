package com.sam.weather.weatherapp;

import java.util.HashMap;

class CacheEntry{
    City city;
    long timestamp;
    public CacheEntry(City city, long timestamp){
        this.city = city;
        this.timestamp = timestamp;
    }
}

/**
 * Caches api calls for quick lookup.
 */
public class WeatherCache {

    private HashMap<String, CacheEntry> cache;

    private final int CACHE_TIMESTAMP = 10 * 60 * 1000;

    public WeatherCache(){
        cache = new HashMap<>();
    }

    public City get(String city){
        CacheEntry entry = cache.get(city);
        if (entry == null) return null;

        if (System.currentTimeMillis() - entry.timestamp < CACHE_TIMESTAMP){
            System.out.println("Got from cache");
            return entry.city;
        }else{
            cache.remove(city);
            return null;
        }
    }

    public void put(String city, City data){
        cache.put(city, new CacheEntry(data, System.currentTimeMillis()));
    }
}
