package com.example.weather.utils

import com.example.weather.data.api.classesDTO.Forecastday
import com.example.weather.data.room.dataEntites.WeatherPerDays

object ConverterWeatherPerDaysFromApi {
    fun convert(list: List<Forecastday>): List<WeatherPerDays> {
        val listOfWeather = mutableListOf<WeatherPerDays>()
       /* val listOfWeatherPerHours = mutableListOf<WeatherPerHours>()*/
        var id = 0

        list.forEach { forecastDay ->
            id++
            listOfWeather.add(
                WeatherPerDays(
                    id = id,
                    date = forecastDay.date,
                    maxTemperature = forecastDay.day.maxtemp_c.toString(),
                    minTemperature = forecastDay.day.mintemp_c.toString(),
                    maxWindSpeed = forecastDay.day.maxwind_kph.toString(),
                    averageHumidity = forecastDay.day.avghumidity.toString(),
                    chanceOfRain = forecastDay.day.daily_chance_of_rain.toString(),
                    chanceOfSnow = forecastDay.day.daily_chance_of_snow.toString(),
                    weatherCondition = forecastDay.day.condition.text,
                    weatherIcon = forecastDay.day.condition.icon,
                    timeOfSunrise = forecastDay.astro.sunrise,
                    timeOfSunset = forecastDay.astro.sunset
                )
            )
        }
        return listOfWeather
    }
}