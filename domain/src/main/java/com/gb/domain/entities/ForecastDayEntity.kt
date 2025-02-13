package com.gb.domain.entities

data class ForecastDayEntity(
    val date: String,
    val dateEpoch: Long,
    val day: DayForecastEntity,
    val astro: AstroEntity,
    val hour: List<HourlyForecastEntity>
)