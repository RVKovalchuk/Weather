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
        weatherPerDay: WeatherPerDays
    ): List<WeatherPerHours> {
        val result = mutableListOf<WeatherPerHours>()
        if (weatherPerHours.value?.isNotEmpty() == true) {
            for (i in weatherPerHours.value ?: emptyList()) {
                if (i.time.substringBefore(' ') == weatherPerDay.date) {
                    result.add(i)
                }
            }
        }
        return result
    }
}