package com.example.weather.view.recyclersView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.room.dataEntites.WeatherPerHours
import com.example.weather.view.viewHolders.WeatherPerHoursViewHolder

class WeatherPerHoursRecyclerViewAdapter : RecyclerView.Adapter<WeatherPerHoursViewHolder>() {
    private val items = mutableListOf<WeatherPerHours>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherPerHoursViewHolder =
        WeatherPerHoursViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.weather_per_hours_item, parent, false)
        )

    override fun onBindViewHolder(holder: WeatherPerHoursViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun addItems(list: List<WeatherPerHours>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}