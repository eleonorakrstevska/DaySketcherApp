package com.example.daysketcher.domain.model

data class Weather(
    val location: String,
    val temperature: Double,
    val condition: String,
    val humidity: Int,
    val lastUpdated: Long
)