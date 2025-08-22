package com.example.daysketcher.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey val location: String,
    val tempC: Double,
    val condition: String,
    val humidity: Int,
    val lastUpdated: Long
)