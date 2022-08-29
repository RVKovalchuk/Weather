package com.example.weather.utils

data class WeatherPerDays(
    val date: String,
    val maxTemperature: String,
    val minTemperature: String,
    val maxWindSpeed: String,
    val averageHumidity: String,
    val chanceOfRain: String,
    val chanceOfSnow: String,
    val weatherCondition: String,
    val weatherIcon: String,
    val timeOfSunrise: String,
    val timeOfSunset: String,
    val listOfWeatherPerHours: List<WeatherPerHours>
)