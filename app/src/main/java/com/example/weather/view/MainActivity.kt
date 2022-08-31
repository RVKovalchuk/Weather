package com.example.weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather.R
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.data.room.dataEntites.WeatherPerHours
import com.example.weather.view.fragment.WeatherPerDaysFragment
import com.example.weather.view.fragment.WeatherPerHoursFragment
import com.example.weather.view.viewHolders.ConstantsHolders


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDaysWeatherFragment()
    }

    //Переключение на фрагмент с погодой по дням
    private fun setDaysWeatherFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_activity_fragments_placeholder, WeatherPerDaysFragment())
            .addToBackStack(null)
            .commit()
    }

    fun launchWeatherPerHoursFragment(weatherPerDays: WeatherPerDays) {
        val bundle = Bundle()
        bundle.putParcelable(
            ConstantsHolders.BUNDLES_KEY_FOR_WEATHER_PER_HOURS_FRAGMENT,
            weatherPerDays
        )
        val weatherPerHoursFragment = WeatherPerHoursFragment()
        weatherPerHoursFragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_activity_fragments_placeholder, weatherPerHoursFragment)
            .addToBackStack(null)
            .commit()
    }

}