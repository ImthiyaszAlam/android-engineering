package com.imthiyas.weatherapp.domain.model

data class WeatherResponse(
    val name: String,
    val main: Main,
    val weather: List<Weather>
)