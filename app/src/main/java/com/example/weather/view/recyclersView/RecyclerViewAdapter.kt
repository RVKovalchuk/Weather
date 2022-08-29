package com.example.weather.view.recyclersView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.view.viewHolders.WeatherViewHolder

class RecyclerViewAdapter : RecyclerView.Adapter<WeatherViewHolder>() {
    private val items = mutableListOf<WeatherPerDays>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder =
        WeatherViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addItems(list: List<WeatherPerDays>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}