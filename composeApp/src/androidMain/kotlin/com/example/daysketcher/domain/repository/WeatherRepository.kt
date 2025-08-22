package com.example.daysketcher.domain.repository

import com.example.daysketcher.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(location: String): Weather
    suspend fun searchWeather(query: String): Weather
}