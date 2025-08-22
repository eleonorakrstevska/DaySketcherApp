package com.example.daysketcher.domain.usecase

import com.example.daysketcher.domain.model.Weather
import com.example.daysketcher.domain.repository.WeatherRepository

class SearchWeatherUseCase(private val repository: WeatherRepository) {
    suspend operator fun invoke(query: String): Weather {
        return repository.searchWeather(query)
    }
}