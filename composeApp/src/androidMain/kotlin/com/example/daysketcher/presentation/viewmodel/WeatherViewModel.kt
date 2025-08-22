package com.example.daysketcher.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daysketcher.domain.model.Weather
import com.example.daysketcher.presentation.state.WeatherState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _state = MutableStateFlow<WeatherState>(WeatherState.Idle)
    val state: StateFlow<WeatherState> = _state

    fun loadWeather(query: String = "Skopje") {
        viewModelScope.launch {
            _state.value = WeatherState.Loading
            delay(2000) // симулираме повик кон API

            // Fake податоци
            val fakeWeather = Weather(
                location = query,
                temperature = 27.5,
                condition = "Sunny",
                humidity = 45,
                lastUpdated = System.currentTimeMillis()
            )

            _state.value = WeatherState.Success(fakeWeather)
        }
    }
}
