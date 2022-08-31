package com.example.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weather.App
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.data.room.dataEntites.WeatherPerHours
import com.example.weather.model.domain.Receiver
import javax.inject.Inject

class WeatherPerHoursFragmentViewModel : ViewModel() {
    @Inject
    lateinit var receiver: Receiver

    val weatherPerHours: LiveData<List<WeatherPerHours>>

    init {
        App.instance.dagger.inject(this)
        weatherPerHours = receiver.getWeatherPerHoursFromDb()
    }

    fun selectWeatherPerHoursForChosenDay(
        listWeatherPerHours: List<WeatherPerHours>,
        weatherPerDay: WeatherPerDays
    ): List<WeatherPerHours> {
        val result = mutableListOf<WeatherPerHours>()
        if (listWeatherPerHours.isNotEmpty()) {
            for (i in listWeatherPerHours.indices) {
                if (listWeatherPerHours[i].time.substringBefore(' ') == weatherPerDay.date) {
                    result.add(listWeatherPerHours[i])
                }
            }
        }
        return result
    }
}