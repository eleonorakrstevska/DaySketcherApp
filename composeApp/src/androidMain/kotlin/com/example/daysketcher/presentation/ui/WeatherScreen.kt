package com.example.daysketcher.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.daysketcher.presentation.viewmodel.WeatherViewModel
import com.example.daysketcher.presentation.state.WeatherState
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = koinViewModel()) {
    val state = viewModel.state.collectAsState()
    var query by remember { mutableStateOf("Skopje") } // default град ако нема локација

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 🔍 Search бар
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Enter city...") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.loadWeather(query) }) {
                Text("Search")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 📊 Weather UI според state
        when (val s = state.value) {
            is WeatherState.Idle -> {
                Text("Fetching weather…")
                // 👇 ова можеш да го замениш со тековна локација
                LaunchedEffect(Unit) {
                    viewModel.loadWeather(query) // default град при прво пуштање
                }
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
                Text("⚠️ Error: ${s.message}")
            }
        }
    }
}
