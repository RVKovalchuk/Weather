package com.example.weather.view.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.room.dataEntites.WeatherPerHours
import com.squareup.picasso.Picasso

class WeatherPerHoursViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(weatherPerHours: WeatherPerHours) {
        val time = itemView.findViewById<TextView>(R.id.item_weather_per_hours_time)
        val windSpeed = itemView.findViewById<TextView>(R.id.item_weather_per_hours_wind_speed)
        val windDirection =
            itemView.findViewById<TextView>(R.id.item_weather_per_hours_wind_direction)
        val humidity = itemView.findViewById<TextView>(R.id.item_weather_per_hours_humidity)
        val chanceOfRain =
            itemView.findViewById<TextView>(R.id.item_weather_per_hours_chance_of_rain)
        val chanceOfSnow =
            itemView.findViewById<TextView>(R.id.item_weather_per_hours_chance_of_snow)
        val temperature = itemView.findViewById<TextView>(R.id.item_weather_per_hours_temperature)
        val condition = itemView.findViewById<TextView>(R.id.item_weather_per_hours_condition)
        val conditionImage =
            itemView.findViewById<ImageView>(R.id.item_weather_per_hours_condition_image)

        time.text = weatherPerHours.time
        val windSpeedText = "Wind speed: ${weatherPerHours.windSpeed} kmph"
        windSpeed.text = windSpeedText
        val windDirectionText = "Wind direction: ${weatherPerHours.directionOfWind}"
        windDirection.text = windDirectionText
        val humidityText = "Humidity: ${weatherPerHours.humidity}"
        humidity.text = humidityText
        val chanceOfRainText = "Chance of rain: ${weatherPerHours.chanceOfRain}"
        chanceOfRain.text = chanceOfRainText
        val chanceOfSnowText = "Chance of snow: ${weatherPerHours.chanceOfSnow}"
        chanceOfSnow.text = chanceOfSnowText
        val temperatureText = "${weatherPerHours.temperature}°C"
        temperature.text = temperatureText
        condition.text = weatherPerHours.weatherCondition

        Picasso.get()
            .load(ConstantsHolders.HTTP + weatherPerHours.weatherIcon)
            .error(R.drawable.ic_error)
            .into(conditionImage)
    }
}