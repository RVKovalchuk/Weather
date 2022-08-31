package com.example.weather.data.room.dataEntites

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "weather_per_days_table")
data class WeatherPerDays(
    @PrimaryKey(autoGenerate = false) val id: Int,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "maxTemperature") val maxTemperature: String,
    @ColumnInfo(name = "minTemperature") val minTemperature: String,
    @ColumnInfo(name = "maxWindSpeed") val maxWindSpeed: String,
    @ColumnInfo(name = "averageHumidity") val averageHumidity: String,
    @ColumnInfo(name = "chanceOfRain") val chanceOfRain: String,
    @ColumnInfo(name = "chanceOfSnow") val chanceOfSnow: String,
    @ColumnInfo(name = "weatherCondition") val weatherCondition: String,
    @ColumnInfo(name = "weatherIcon") val weatherIcon: String,
    @ColumnInfo(name = "timeOfSunrise") val timeOfSunrise: String,
    @ColumnInfo(name = "timeOfSunset") val timeOfSunset: String
) : Parcelable