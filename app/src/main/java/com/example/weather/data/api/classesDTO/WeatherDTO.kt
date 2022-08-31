package com.example.weather.data.api.classesDTO

data class WeatherDTO(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)