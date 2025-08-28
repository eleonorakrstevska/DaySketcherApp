package com.example.daysketcher.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    @SerialName("location") val location: LocationDto,
    @SerialName("current") val current: CurrentDto
)

@Serializable
data class LocationDto(
    @SerialName("name") val name: String,
    @SerialName("country") val country: String
)

@Serializable
data class CurrentDto(
    @SerialName("temp_c") val tempC: Double,
    @SerialName("condition") val condition: ConditionDto,
    @SerialName("humidity") val humidity: Int,
    @SerialName("last_updated_epoch") val lastUpdated: Long
)

@Serializable
data class ConditionDto(
    @SerialName("text") val text: String
)


