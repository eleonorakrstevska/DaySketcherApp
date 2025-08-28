package com.example.daysketcher.di

import com.example.daysketcher.data.remote.WeatherApiService
import com.example.daysketcher.data.remote.WeatherApiServiceImpl
import com.example.daysketcher.data.repository.WeatherRepositoryImpl
import com.example.daysketcher.domain.repository.WeatherRepository
import com.example.daysketcher.presentation.viewmodel.WeatherViewModel
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single {
        HttpClient(io.ktor.client.engine.okhttp.OkHttp) {
            install(ContentNegotiation) {
                json(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                    isLenient = true        
                })
            }
        }
    }

    single<WeatherApiService> {
        WeatherApiServiceImpl(get(), apiKey = "6c7bad0e70cb49e6a4692854251808")
    }

    // Repository
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    viewModel {
        WeatherViewModel(get())
    }
}

