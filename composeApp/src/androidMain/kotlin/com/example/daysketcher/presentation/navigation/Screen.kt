package com.example.daysketcher.presentation.navigation


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Weather : Screen("weather")
}
