package com.example.weather.domain

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.weather.data.api.ConstantsApi
import com.example.weather.data.api.RetrofitInterface
import com.example.weather.data.api.classesDTO.WeatherDTO
import com.example.weather.data.MainRepository
import com.example.weather.data.room.dataEntites.CurrentWeather
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.data.room.dataEntites.WeatherPerHours
import com.example.weather.utils.ConverterCurrentWeatherFromApi
import com.example.weather.utils.ConverterWeatherPerDaysFromApi
import com.example.weather.utils.ConverterWeatherPerHoursFromApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
                    val listWeatherPerDays =
                        ConverterWeatherPerDaysFromApi.convert(response.body()!!.forecast.forecastday)
                    repository.insertToDbWeatherPerDays(list = listWeatherPerDays)

                    val listWeatherPerHours =
                        ConverterWeatherPerHoursFromApi.convert(response.body()!!.forecast.forecastday)
                    repository.insertToDbWeatherPerHours(list = listWeatherPerHours)

                    val currentWeather = ConverterCurrentWeatherFromApi.convert(response.body()!!)
                    repository.insertToDbCurrentWeather(currentWeather = currentWeather)
                }

                override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
                    println(t.localizedMessage)
                    t.localizedMessage?.let { Log.d("!!!", it) }
                }
            })

    }

    fun getCurrentWeatherFromDb(): LiveData<CurrentWeather> = repository.getFromDbCurrentWeather()
    fun getWeatherPerDaysFromDb() : LiveData<List<WeatherPerDays>> = repository.getFromDbWeatherPerDays()
    fun getWeatherPerHoursFromDb() : LiveData<List<WeatherPerHours>> = repository.getFromDbWeatherPerHours()
}