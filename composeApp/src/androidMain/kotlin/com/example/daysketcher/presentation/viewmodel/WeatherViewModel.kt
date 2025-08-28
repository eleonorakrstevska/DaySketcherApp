package com.example.daysketcher.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daysketcher.domain.repository.WeatherRepository
import com.example.daysketcher.presentation.state.WeatherState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow<WeatherState>(WeatherState.Idle)
    val state: StateFlow<WeatherState> = _state

    fun loadWeather(location: String) {
        viewModelScope.launch {
            _state.value = WeatherState.Loading
            try {
                val weather = repository.getWeather(location)
                _state.value = WeatherState.Success(weather)
            } catch (e: Exception) {
                _state.value = WeatherState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }

    fun searchWeather(query: String) {
        viewModelScope.launch {
            _state.value = WeatherState.Loading
            try {
                val weather = repository.searchWeather(query)
                _state.value = WeatherState.Success(weather)
            } catch (e: Exception) {
                _state.value = WeatherState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}
