package com.example.daysketcher.data.remote

interface WeatherApiService {
    suspend fun fetchCurrentWeather(location: String): WeatherDto
    suspend fun searchWeather(query: String): List<WeatherDto>
}
