package com.example.weather.model.utils

import com.example.weather.data.api.classesDTO.WeatherDTO
import com.example.weather.data.room.dataEntites.CurrentWeather

object ConverterCurrentWeatherFromApi {
    fun convert(weather: WeatherDTO): CurrentWeather = CurrentWeather(
        city = weather.location.name,
        country = weather.location.country,
        timeUpdate = weather.current.last_updated,
        temperature = weather.current.temp_c.toString(),
        condition = weather.current.condition.text,
        conditionImage = weather.current.condition.icon,
        windSpeed = weather.current.wind_kph.toString(),
        windDirection = weather.current.wind_dir,
        humidity = weather.current.humidity.toString(),
        feelsLike = weather.current.feelslike_c.toString()
    )
}