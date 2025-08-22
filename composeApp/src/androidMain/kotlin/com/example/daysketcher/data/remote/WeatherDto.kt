package com.example.daysketcher.data.remote

data class WeatherDto(
    val location: String,
    val tempC: Double,
    val condition: String,
    val humidity: Int
)