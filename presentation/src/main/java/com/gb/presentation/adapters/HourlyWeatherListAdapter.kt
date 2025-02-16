package com.gb.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gb.domain.entities.HourlyForecastEntity
import com.gb.presentation.common.loadImage
import com.gb.presentation.common.toHours
import com.gb.presentation.databinding.ItemHourlyForecastBinding
import kotlin.math.roundToInt

class HourlyWeatherListAdapter(): ListAdapter<HourlyForecastEntity, HourlyWeatherListAdapter.HourlyForecastViewHolder>(HourlyForecastDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyForecastViewHolder {
        return HourlyForecastViewHolder(ItemHourlyForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HourlyForecastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HourlyForecastViewHolder(private val binding: ItemHourlyForecastBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HourlyForecastEntity) {
            binding.time.text = item.time.toHours()
            binding.hourlyWeatherDegree.text = "${item.tempC.roundToInt()}°"
            binding.hourlyWeatherIcon.loadImage(binding.root.context, item.condition.imageUrl)
        }
    }

    class HourlyForecastDiffCallback : DiffUtil.ItemCallback<HourlyForecastEntity>() {
        override fun areItemsTheSame(oldItem: HourlyForecastEntity, newItem: HourlyForecastEntity): Boolean {
            return oldItem.toString() == newItem.toString()
        }

        override fun areContentsTheSame(oldItem: HourlyForecastEntity, newItem: HourlyForecastEntity): Boolean {
            return oldItem == newItem
        }
    }

}