package com.example.daysketcher.data.remote

import com.example.daysketcher.data.remote.WeatherDto

interface WeatherApiService {
    suspend fun getCurrentWeather(location: String): WeatherDto
}
