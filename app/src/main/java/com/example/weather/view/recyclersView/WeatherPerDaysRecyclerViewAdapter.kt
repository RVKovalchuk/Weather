package com.example.weather.view.recyclersView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.view.viewHolders.WeatherPerDaysViewHolder

class WeatherPerDaysRecyclerViewAdapter(private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<WeatherPerDaysViewHolder>() {
    private val items = mutableListOf<WeatherPerDays>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherPerDaysViewHolder =
        WeatherPerDaysViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.weather_per_days_item, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WeatherPerDaysViewHolder, position: Int) {

        holder.bind(items[position])
        val container =
            holder.itemView.findViewById<ConstraintLayout>(R.id.item_weather_per_days_container)
        container.setOnClickListener {
            clickListener.clickOnItem(items[position])
        }
    }

    fun addItems(list: List<WeatherPerDays>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun clickOnItem(weatherPerDay: WeatherPerDays)
    }

}