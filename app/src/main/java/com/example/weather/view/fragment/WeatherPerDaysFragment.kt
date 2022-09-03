package com.example.weather.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.room.dataEntites.CurrentWeather
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.view.MainActivity
import com.example.weather.view.recyclersView.WeatherPerDaysRecyclerViewAdapter
import com.example.weather.view.viewHolders.ConstantsHolders
import com.example.weather.viewmodel.WeatherPerDaysFragmentViewModel
import com.squareup.picasso.Picasso


class WeatherPerDaysFragment : Fragment() {
    private val viewModel: WeatherPerDaysFragmentViewModel by activityViewModels()
    private lateinit var weatherAdapter: WeatherPerDaysRecyclerViewAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickOnButtonRefresh()
        clickOnButtonSearch()
        changeSharedPreferences()
        initRecyclerView()

        viewModel.currentWeather.observe(viewLifecycleOwner) {
            if (it != null) {
                fillMainCard(it)
            }
        }
        viewModel.weatherPerDays.observe(viewLifecycleOwner) {
            if (it != null) {
                weatherAdapter.addItems(it)
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView =
            requireView().findViewById<RecyclerView>(R.id.fragment_weather_per_days_recyclerview)
        weatherAdapter = WeatherPerDaysRecyclerViewAdapter(object :
            WeatherPerDaysRecyclerViewAdapter.OnItemClickListener {
            override fun clickOnItem(weatherPerDay: WeatherPerDays) {
                (requireActivity() as MainActivity).launchWeatherPerHoursFragment(weatherPerDays = weatherPerDay)
            }
        })
        recyclerView.adapter = weatherAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun clickOnButtonRefresh() {
        val buttonRefresh =
            view?.findViewById<ImageButton>(R.id.fragment_weather_per_days_button_refresh)
        buttonRefresh?.setOnClickListener {
            viewModel.receiver.getSharedPreferences()
                ?.let { sharedPreferences -> viewModel.refreshWeathersInfo(sharedPreferences) }
        }
    }

    private fun clickOnButtonSearch() {
        val buttonSearch =
            view?.findViewById<ImageButton>(R.id.fragment_weather_per_days_button_search)
        val editText = view?.findViewById<EditText>(R.id.fragment_weather_per_days_edittext_city)

        buttonSearch?.setOnClickListener {
            if (editText?.isVisible == false) {
                editText.isVisible = true
            } else {
                editText?.isVisible = false
            }
        }
    }

    private fun changeSharedPreferences() {
        val editText = view?.findViewById<EditText>(R.id.fragment_weather_per_days_edittext_city)

        editText?.setOnEditorActionListener { textView, i, _ ->
            when (i) {
                EditorInfo.IME_ACTION_DONE -> {
                    textView.text.let {
                        viewModel.refreshWeathersInfo(it.toString())
                        viewModel.insertToSharedPreferences(it.toString())
                    }
                }
            }
            true
        }
    }

    private fun fillMainCard(currentWeather: CurrentWeather) {
        val date =
            requireView().findViewById<TextView>(R.id.fragment_weather_per_days_textview_date)
        val city =
            requireView().findViewById<TextView>(R.id.fragment_weather_per_days_textview_city)
        val country =
            requireView().findViewById<TextView>(R.id.fragment_weather_per_days_textview_country)
        val condition =
            requireView().findViewById<TextView>(R.id.fragment_weather_per_days_textview_condition)
        val temperature =
            requireView().findViewById<TextView>(R.id.fragment_weather_per_days_textview_temperature)
        val humidity =
            requireView().findViewById<TextView>(R.id.fragment_weather_per_days_textview_humidity)
        val windSpeed =
            requireView().findViewById<TextView>(R.id.fragment_weather_per_days_textview_wind_speed)
        val windDirection =
            requireView().findViewById<TextView>(R.id.fragment_weather_per_days_textview_wind_direction)
        val conditionImage =
            requireView().findViewById<ImageView>(R.id.fragment_weather_per_days_imageview_condition_image)

        date.text = currentWeather.timeUpdate
        city.text = currentWeather.city
        country.text = currentWeather.country
        condition.text = currentWeather.condition
        val temperatureText =
            "${currentWeather.temperature}°C (Feels like ${currentWeather.feelsLike}°C)"
        temperature.text = temperatureText
        val humidityText = "Humidity: ${currentWeather.humidity}%"
        humidity.text = humidityText
        val windSpeedText = "Wind speed: ${currentWeather.windSpeed} kmph"
        windSpeed.text = windSpeedText
        val windDirectionText = "Wind direction: ${currentWeather.windDirection}"
        windDirection.text = windDirectionText

        Picasso.get()
            .load(ConstantsHolders.HTTP + currentWeather.conditionImage)
            .into(conditionImage)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_per_days, container, false)
    }
}