package com.example.weather.classesDTO

data class WeatherDTO(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)