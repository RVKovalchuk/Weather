package com.example.weather.utils

data class WeatherPerHours(
    val time: String,
    val temperature: String,
    val windSpeed: String,
    val directionOfWind: String,
    val humidity: String,
    val chanceOfRain: String,
    val chanceOfSnow: String,
    val weatherCondition: String,
    val weatherIcon: String
)