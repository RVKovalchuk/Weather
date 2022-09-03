package com.example.weather.model.domain

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.weather.App
import com.example.weather.data.api.ConstantsApi
import com.example.weather.data.api.RetrofitInterface
import com.example.weather.data.api.classesDTO.WeatherDTO
import com.example.weather.data.MainRepository
import com.example.weather.data.room.dataEntites.CurrentWeather
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.data.room.dataEntites.WeatherPerHours
import com.example.weather.model.utils.ConverterCurrentWeatherFromApi
import com.example.weather.model.utils.ConverterWeatherPerDaysFromApi
import com.example.weather.model.utils.ConverterWeatherPerHoursFromApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.NullPointerException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Receiver @Inject constructor(
    private val service: RetrofitInterface,
    private val repository: MainRepository
) {
    fun getWeatherInfoFromApi(city: String) {
        service.getWeatherFromApi(key = ConstantsApi.API_KEY, city = city)
            .enqueue(object : Callback<WeatherDTO> {
                override fun onResponse(call: Call<WeatherDTO>, response: Response<WeatherDTO>) {
                    try {
                        val listWeatherPerDays =
                            ConverterWeatherPerDaysFromApi.convert(response.body()!!.forecast.forecastday)
                        repository.insertToDbWeatherPerDays(list = listWeatherPerDays)

                        val listWeatherPerHours =
                            ConverterWeatherPerHoursFromApi.convert(response.body()!!.forecast.forecastday)
                        repository.insertToDbWeatherPerHours(list = listWeatherPerHours)

                        val currentWeather =
                            ConverterCurrentWeatherFromApi.convert(response.body()!!)
                        repository.insertToDbCurrentWeather(currentWeather = currentWeather)
                    } catch (e: NullPointerException) {
                        Toast.makeText(App.instance, "Incorrect input", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
                    println(t.localizedMessage)
                    t.localizedMessage?.let { Log.d("!!!", it) }
                }
            })
    }

    fun getCurrentWeatherFromDb(): LiveData<CurrentWeather> = repository.getFromDbCurrentWeather()
    fun getWeatherPerDaysFromDb(): LiveData<List<WeatherPerDays>> =
        repository.getFromDbWeatherPerDays()

    fun getWeatherPerHoursFromDb(): LiveData<List<WeatherPerHours>> =
        repository.getFromDbWeatherPerHours()

    fun getSharedPreferences(): String? = repository.getFromSharedPreferences()
    fun insertToSharedPreferences(city: String) = repository.insertToSharedPreferences(city = city)
}