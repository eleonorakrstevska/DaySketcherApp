package com.example.daysketcher.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.daysketcher.presentation.viewmodel.WeatherViewModel
import com.example.daysketcher.presentation.state.WeatherState

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {
    val state = viewModel.state.collectAsState()

    when (val s = state.value) {
        is WeatherState.Idle -> {
            Text("Loading weather…")
            viewModel.loadWeather()
        }
        is WeatherState.Loading -> {
            CircularProgressIndicator()
        }
        is WeatherState.Success -> {
            val weather = s.weather
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("📍 ${weather.location}")
                Text("🌡️ ${weather.temperature}°C")
                Text("☀️ ${weather.condition}")
                Text("💧 Humidity: ${weather.humidity}%")
            }
        }
        is WeatherState.Error -> {
            Text("Error: ${s.message}")
        }
    }
}
