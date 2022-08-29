package com.example.weather.utils

import androidx.lifecycle.LiveData
import com.example.weather.classesDTO.Forecastday

object ConverterForecastFromApiToApp {
    fun convert(list: List<Forecastday>): List<WeatherPerDays> {
        val listOfWeather = mutableListOf<WeatherPerDays>()
        val listOfWeatherPerHours = mutableListOf<WeatherPerHours>()

        list.forEach { forecastDay ->
            forecastDay.hour.forEach { hour ->
                listOfWeatherPerHours.add(
                    WeatherPerHours(
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
            listOfWeather.add(
                WeatherPerDays(
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
                    timeOfSunset = forecastDay.astro.sunset,
                    listOfWeatherPerHours = listOfWeatherPerHours,
                )
            )
        }
        return listOfWeather
    }
}