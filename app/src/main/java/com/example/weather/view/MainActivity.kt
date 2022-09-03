package com.example.weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.appcompat.app.AlertDialog
import com.example.weather.R
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.view.fragment.WeatherPerDaysFragment
import com.example.weather.view.fragment.WeatherPerHoursFragment
import com.example.weather.view.viewHolders.ConstantsHolders


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDaysWeatherFragment()
    }

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

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            super.onBackPressed()
            AlertDialog.Builder(ContextThemeWrapper(this, R.style.Theme_MovieSearch_DialogAlert))
                .setTitle(R.string.title)
                .setIcon(R.drawable.ic_exit)
                .setPositiveButton(R.string.button_positive) { _, _ ->
                    finish()
                }
                .setNegativeButton(R.string.button_negative) { _, _ ->
                    setDaysWeatherFragment()
                }
                .show()
        } else {
            super.onBackPressed()
        }
    }

}