package com.example.weather.data.room.dataEntites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_per_hours_table")
data class WeatherPerHours(
    @PrimaryKey(autoGenerate = false) val id: Int,
    @ColumnInfo(name = "time") val time: String,
    @ColumnInfo(name = "temperature") val temperature: String,
    @ColumnInfo(name = "windSpeed") val windSpeed: String,
    @ColumnInfo(name = "directionOfWind") val directionOfWind: String,
    @ColumnInfo(name = "humidity") val humidity: String,
    @ColumnInfo(name = "chanceOfRain") val chanceOfRain: String,
    @ColumnInfo(name = "chanceOfSnow") val chanceOfSnow: String,
    @ColumnInfo(name = "weatherCondition") val weatherCondition: String,
    @ColumnInfo(name = "weatherIcon") val weatherIcon: String
)