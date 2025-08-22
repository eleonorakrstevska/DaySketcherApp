package com.example.daysketcher.data.repository

import com.example.daysketcher.data.cache.WeatherCache
import com.example.daysketcher.data.mapper.WeatherMapper
import com.example.daysketcher.data.remote.WeatherApiService
import com.example.daysketcher.domain.model.Weather
import com.example.daysketcher.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val apiService: WeatherApiService,
    private val cache: WeatherCache,
    private val mapper: WeatherMapper
) : WeatherRepository {

    override suspend fun getWeather(location: String): Weather {
        TODO()
    }

    override suspend fun searchWeather(query: String): Weather {
        TODO()
    }
}
