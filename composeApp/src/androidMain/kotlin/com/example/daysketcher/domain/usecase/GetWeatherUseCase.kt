package com.example.daysketcher.domain.usecase

import com.example.daysketcher.domain.model.Weather
import com.example.daysketcher.domain.repository.WeatherRepository

class GetWeatherUseCase(private val repository: WeatherRepository) {
    suspend operator fun invoke(location: String): Weather {
        return repository.getWeather(location)
    }
}


