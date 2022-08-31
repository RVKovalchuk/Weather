package com.example.weather.view.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.squareup.picasso.Picasso

class WeatherPerDaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(weatherPerDay: WeatherPerDays) {
        val date = itemView.findViewById<TextView>(R.id.list_item_weather_date)
        val weatherType = itemView.findViewById<TextView>(R.id.list_item_weather_type)
        val temperature = itemView.findViewById<TextView>(R.id.list_item_weather_temperature)
        val image = itemView.findViewById<ImageView>(R.id.list_item_weather_image)

        date.text = weatherPerDay.date
        weatherType.text = weatherPerDay.weatherCondition
        val text = "${weatherPerDay.maxTemperature}°C / ${weatherPerDay.minTemperature}°C"
        temperature.text = text

        Picasso.get()
            .load(ConstantsHolders.HTTP + weatherPerDay.weatherIcon)
            .error(R.drawable.ic_error)
            .into(image)
    }
}
