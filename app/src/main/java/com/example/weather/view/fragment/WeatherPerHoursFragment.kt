package com.example.weather.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.view.recyclersView.WeatherPerHoursRecyclerViewAdapter
import com.example.weather.view.viewHolders.ConstantsHolders
import com.example.weather.viewmodel.WeatherPerHoursFragmentViewModel
import com.squareup.picasso.Picasso

class WeatherPerHoursFragment : Fragment() {
    private val viewModel: WeatherPerHoursFragmentViewModel by activityViewModels()
    private lateinit var weatherPerHoursRecyclerviewAdapter: WeatherPerHoursRecyclerViewAdapter
    private lateinit var weatherPerDays: WeatherPerDays
    private lateinit var weatherPerCurrentDay: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_per_hours, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWeatherPerDaysToMainCard()
        initRecyclerView()
        shareWeather(weatherPerCurrentDay)

        weatherPerHoursRecyclerviewAdapter.addItems(
            viewModel.selectWeatherPerHoursForChosenDay(weatherPerDays)
        )

        viewModel.weatherPerHours.observe(viewLifecycleOwner) {
            if (it != null) {
                weatherPerHoursRecyclerviewAdapter.addItems(
                    viewModel.selectWeatherPerHoursForChosenDay(weatherPerDays)
                )
            }
        }
    }

    private fun setWeatherPerDaysToMainCard() {
        weatherPerDays =
            arguments?.getParcelable<WeatherPerDays>(ConstantsHolders.BUNDLES_KEY_FOR_WEATHER_PER_HOURS_FRAGMENT)
                    as WeatherPerDays
        val date = view?.findViewById<TextView>(R.id.fragment_weather_per_hours_date)
        val temperature = view?.findViewById<TextView>(R.id.fragment_weather_per_hours_temperature)
        val condition = view?.findViewById<TextView>(R.id.fragment_weather_per_hours_condition)
        val wind = view?.findViewById<TextView>(R.id.fragment_weather_per_hours_max_wind_speed)
        val humidity =
            view?.findViewById<TextView>(R.id.fragment_weather_per_hours_average_humidity)
        val chance =
            view?.findViewById<TextView>(R.id.fragment_weather_per_hours_chance_of_rain_and_snow)
        val sunrise = view?.findViewById<TextView>(R.id.fragment_weather_per_hours_time_of_sunrise)
        val sunset = view?.findViewById<TextView>(R.id.fragment_weather_per_hours_time_of_sunset)
        val conditionImage =
            view?.findViewById<ImageView>(R.id.fragment_weather_per_hours_condition_image)
        date?.text = weatherPerDays.date
        val maxAndMinTemperature =
            "Temperature: ${weatherPerDays.maxTemperature}°C / ${weatherPerDays.minTemperature}°C"
        temperature?.text = maxAndMinTemperature
        condition?.text = weatherPerDays.weatherCondition
        val windSpeed = "Max wind speed: ${weatherPerDays.maxWindSpeed} kmph"
        wind?.text = windSpeed
        val averageHumidity = "Average humidity: ${weatherPerDays.averageHumidity}%"
        humidity?.text = averageHumidity
        val chanceOfRainAndSnow =
            "Chance of rain / snow: ${weatherPerDays.chanceOfRain}% / ${weatherPerDays.chanceOfSnow}%"
        chance?.text = chanceOfRainAndSnow
        val timeOfSunrise = "Time of sunrise: ${weatherPerDays.timeOfSunrise}"
        sunrise?.text = timeOfSunrise
        val timeOfSunset = "Time of sunrise: ${weatherPerDays.timeOfSunset}"
        sunset?.text = timeOfSunset

        Picasso.get()
            .load(ConstantsHolders.HTTP + weatherPerDays.weatherIcon)
            .error(R.drawable.ic_error)
            .into(conditionImage)

        weatherPerCurrentDay = "Expected weather for ${weatherPerDays.date}.\n" +
                "$maxAndMinTemperature.\nCondition: ${weatherPerDays.weatherCondition}.\n" +
                "$windSpeed.\n$averageHumidity.\n$chanceOfRainAndSnow.\n$timeOfSunrise.\n$timeOfSunset."

    }

    private fun initRecyclerView() {
        val recyclerView =
            view?.findViewById<RecyclerView>(R.id.fragment_weather_per_hours_recyclerview)
        weatherPerHoursRecyclerviewAdapter = WeatherPerHoursRecyclerViewAdapter()
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.adapter = weatherPerHoursRecyclerviewAdapter
        weatherPerHoursRecyclerviewAdapter.addItems(
            viewModel.selectWeatherPerHoursForChosenDay(weatherPerDays)
        )
    }

    private fun shareWeather(weatherPerCurrentDay: String) {
        val buttonShare =
            view?.findViewById<ImageButton>(R.id.fragment_weather_per_hours_button_share)
        buttonShare?.setOnClickListener {
            startActivity(viewModel.shareWeatherPerCurrentDay(weatherPerCurrentDay))
        }
    }
}