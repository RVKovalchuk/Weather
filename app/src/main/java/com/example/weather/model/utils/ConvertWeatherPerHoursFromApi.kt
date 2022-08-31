package com.example.weather.model.utils

import com.example.weather.data.api.classesDTO.Forecastday
import com.example.weather.data.room.dataEntites.WeatherPerHours

object ConverterWeatherPerHoursFromApi {
    fun convert(list: List<Forecastday>): List<WeatherPerHours> {
        val listOfWeatherPerHours = mutableListOf<WeatherPerHours>()
        var id = 0
        list.forEach { forecastDay ->
            forecastDay.hour.forEach { hour ->
                id++
                listOfWeatherPerHours.add(
                    WeatherPerHours(
                        id = id,
                        time = hour.time,
                        temperature = hour.temp_c.toString(),
                        windSpeed = hour.wind_kph.toString(),
                        directionOfWind = hour.wind_dir,
                        humidity = hour.humidity.toString(),
                        chanceOfRain = hour.chance_of_rain.toString(),
                        chanceOfSnow = hour.chance_of_snow.toString(),
                        weatherCondition = hour.condition.text,
                        weatherIcon = hour.condition.icon
                    )
                )
            }
        }
        return listOfWeatherPerHours
    }
}