package com.example.daysketcher.data.cache

import com.example.daysketcher.domain.model.Weather

interface WeatherCache {
    suspend fun save(weather: Weather)
    suspend fun get(location: String): Weather?
}