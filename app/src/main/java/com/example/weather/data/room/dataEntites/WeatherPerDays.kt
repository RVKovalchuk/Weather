package com.example.weather.data.room.dataEntites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weather.utils.WeatherPerHours
@Entity(tableName = "weather_per_days_table")
data class WeatherPerDays(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "date")val date: String,
    @ColumnInfo(name = "maxTemperature")val maxTemperature: String,
    @ColumnInfo(name = "minTemperature")val minTemperature: String,
    @ColumnInfo(name = "maxWindSpeed") val maxWindSpeed: String,
    @ColumnInfo(name = "averageHumidity")val averageHumidity: String,
    @ColumnInfo(name = "chanceOfRain")val chanceOfRain: String,
    @ColumnInfo(name = "chanceOfSnow")val chanceOfSnow: String,
    @ColumnInfo(name = "weatherCondition")val weatherCondition: String,
    @ColumnInfo(name = "weatherIcon")val weatherIcon: String,
    @ColumnInfo(name = "timeOfSunrise")val timeOfSunrise: String,
    @ColumnInfo(name = "timeOfSunset")val timeOfSunset: String,
    @ColumnInfo(name = "date")val listOfWeatherPerHours: List<WeatherPerHours>
)