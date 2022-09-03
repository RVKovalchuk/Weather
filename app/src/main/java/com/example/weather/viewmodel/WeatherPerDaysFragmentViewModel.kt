package com.example.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weather.App
import com.example.weather.data.room.dataEntites.CurrentWeather
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.data.sharedPreferences.ConstantsSharedPreferences
import com.example.weather.model.domain.Receiver
import javax.inject.Inject

class WeatherPerDaysFragmentViewModel : ViewModel() {
    @Inject
    lateinit var receiver: Receiver

    val currentWeather: LiveData<CurrentWeather>
    val weatherPerDays: LiveData<List<WeatherPerDays>>

    var city: String = ""

    init {
        App.instance.dagger.inject(this)
        city = receiver.getSharedPreferences().toString()
        receiver.getWeatherInfoFromApi(city.ifBlank { ConstantsSharedPreferences.DEFAULT_LOCATION })
        currentWeather = receiver.getCurrentWeatherFromDb()
        weatherPerDays = receiver.getWeatherPerDaysFromDb()
    }

    fun refreshWeathersInfo(city: String) {
        receiver.getWeatherInfoFromApi(city = city)
    }

    fun insertToSharedPreferences(city: String) {
        receiver.insertToSharedPreferences(city = city)
    }

}