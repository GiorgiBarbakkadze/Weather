package com.gb.domain.entities

import java.io.Serializable

data class ForecastDayEntity(
    val date: String,
    val dateEpoch: Long,
    val day: DayForecastEntity,
    val astro: AstroEntity,
    val hour: List<HourlyForecastEntity>
): Serializable