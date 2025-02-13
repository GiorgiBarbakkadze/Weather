package com.gb.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gb.domain.entities.ForecastDayEntity
import com.gb.presentation.common.loadImage
import com.gb.presentation.databinding.ItemDaysForecastBinding
import kotlin.math.roundToInt

class DaysForecastAdapter() :
    ListAdapter<ForecastDayEntity, DaysForecastAdapter.ForecastDayViewHolder>(
        DaysForecastDiffUtilCallBack()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastDayViewHolder {
        return ForecastDayViewHolder(
            ItemDaysForecastBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ForecastDayViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ForecastDayViewHolder(private val binding: ItemDaysForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ForecastDayEntity) {
            binding.date.text = item.date
            binding.DaysWeatherIcon.loadImage(binding.root.context, item.day.condition.imageUrl)
            binding.daysWeatherDegrees.text = "${item.day.maxTempC.roundToInt()}°/ ${item.day.minTempC.roundToInt()}°"
        }
    }


    class DaysForecastDiffUtilCallBack : DiffUtil.ItemCallback<ForecastDayEntity>() {
        override fun areItemsTheSame(
            oldItem: ForecastDayEntity,
            newItem: ForecastDayEntity
        ): Boolean {
            return oldItem.toString() == newItem.toString()
        }

        override fun areContentsTheSame(
            oldItem: ForecastDayEntity,
            newItem: ForecastDayEntity
        ): Boolean {
            return oldItem == newItem
        }
    }
}