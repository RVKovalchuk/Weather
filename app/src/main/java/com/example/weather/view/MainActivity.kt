package com.example.weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather.R
import com.example.weather.view.fragment.DaysWeatherFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDaysWeatherFragment()
    }

    //Переключение на фрагмент с погодой по дням
    private fun setDaysWeatherFragment(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_activity_fragments_placeholder, DaysWeatherFragment())
            .addToBackStack(null)
            .commit()
    }

}