package com.example.daysketcher.data.repository

import com.example.daysketcher.data.remote.WeatherApiService
import com.example.daysketcher.domain.model.Weather
import com.example.daysketcher.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherApiService
) : WeatherRepository {

    override suspend fun getWeather(location: String): Weather {
        val dto = api.getCurrentWeather(location)
        return Weather(
            location = dto.location.name,
            temperature = dto.current.tempC,
            condition = dto.current.condition.text,
            humidity = dto.current.humidity,
            lastUpdated = System.currentTimeMillis()
        )
    }

    override suspend fun searchWeather(query: String): Weather {
        val dto = api.getCurrentWeather(query)
        return Weather(
            location = dto.location.name,
            temperature = dto.current.tempC,
            condition = dto.current.condition.text,
            humidity = dto.current.humidity,
            lastUpdated = System.currentTimeMillis()
        )
    }
}

