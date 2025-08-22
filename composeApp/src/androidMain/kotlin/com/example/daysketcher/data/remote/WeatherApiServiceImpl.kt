package com.example.daysketcher.data.remote

class WeatherApiServiceImpl : WeatherApiService {
    override suspend fun fetchCurrentWeather(location: String): WeatherDto {
        TODO("Implement Ktor API call with error handling")
    }

    override suspend fun searchWeather(query: String): List<WeatherDto> {
        TODO("Implement Ktor search API call with error handling")
    }
}
