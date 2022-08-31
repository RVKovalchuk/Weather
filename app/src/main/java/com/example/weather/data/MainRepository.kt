package com.example.weather.data

import androidx.lifecycle.LiveData
import com.example.weather.data.room.dataAccessObjects.CurrentWeatherDataAccessObject
import com.example.weather.data.room.dataAccessObjects.WeatherPerDaysDataAccessObject
import com.example.weather.data.room.dataAccessObjects.WeatherPerHoursDataAccessObject
import com.example.weather.data.room.dataEntites.CurrentWeather
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.data.room.dataEntites.WeatherPerHours
import java.util.concurrent.Executors
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val currentWeatherDataAccessObject: CurrentWeatherDataAccessObject,
    private val weatherPerDaysDataAccessObject: WeatherPerDaysDataAccessObject,
    private val weatherPerHoursDataAccessObject: WeatherPerHoursDataAccessObject
) {

    fun insertToDbCurrentWeather(currentWeather: CurrentWeather) {
        Executors.newSingleThreadExecutor().execute {
            currentWeatherDataAccessObject.insertCurrentWeather(currentWeather = currentWeather)
        }
    }

    fun getFromDbCurrentWeather(): LiveData<CurrentWeather> =
        currentWeatherDataAccessObject.getCurrentWeather()

    fun insertToDbWeatherPerDays(list: List<WeatherPerDays>) {
        Executors.newSingleThreadExecutor().execute {
            weatherPerDaysDataAccessObject.insertWeatherPerDaysToDb(list = list)
        }
    }

    fun getFromDbWeatherPerDays(): LiveData<List<WeatherPerDays>> =
        weatherPerDaysDataAccessObject.getWeatherPerDaysFromDb()

    fun insertToDbWeatherPerHours(list: List<WeatherPerHours>) {
        Executors.newSingleThreadExecutor().execute {
            weatherPerHoursDataAccessObject.insertWeatherPerHoursToDb(list = list)
        }
    }

    fun getFromDbWeatherPerHours(): LiveData<List<WeatherPerHours>> =
        weatherPerHoursDataAccessObject.getWeatherPerHoursFromDb()
}