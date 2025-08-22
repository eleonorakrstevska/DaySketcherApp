package com.example.daysketcher.data.mapper

import com.example.daysketcher.data.cache.WeatherEntity
import com.example.daysketcher.data.remote.WeatherDto
import com.example.daysketcher.domain.model.Weather

class WeatherMapper {
    fun fromDto(dto: WeatherDto): Weather = TODO()
    fun fromEntity(entity: WeatherEntity): Weather = TODO()
    fun toEntity(weather: Weather): WeatherEntity = TODO()
}