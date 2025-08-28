package com.example.daysketcher.data.remote


import com.example.daysketcher.data.remote.WeatherDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class WeatherApiServiceImpl(
    private val client: HttpClient,
    private val apiKey: String
) : WeatherApiService {

    override suspend fun getCurrentWeather(location: String): WeatherDto {
        return client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.weatherapi.com"
                encodedPath = "/v1/current.json"
                parameters.append("key", apiKey)
                parameters.append("q", location)
            }
        }.body()
    }
}

