package com.example.weather.data.room.dataEntites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_weather_table")
data class CurrentWeather(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "timeUpdate") val timeUpdate: String,
    @ColumnInfo(name = "temperature") val temperature: String,
    @ColumnInfo(name = "condition") val condition: String,
    @ColumnInfo(name = "conditionImage") val conditionImage: String,
    @ColumnInfo(name = "windSpeed") val windSpeed: String,
    @ColumnInfo(name = "windDirection") val windDirection: String,
    @ColumnInfo(name = "humidity") val humidity: String,
    @ColumnInfo(name = "feelsLike") val feelsLike: String
)