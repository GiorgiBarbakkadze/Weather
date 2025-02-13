package com.gb.data.dto

import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.ForecastDayEntity
import com.gb.domain.entities.ForecastEntity
import com.squareup.moshi.Json


data class Forecast(
    val forecastday: List<ForecastDay>
): MapFromDataToDomain<ForecastEntity> {
    override fun map() = ForecastEntity(forecastday.map { it.map() })
}


data class ForecastDay(
    val date: String,
    @Json(name = "date_epoch") val dateEpoch: Long,
    val day: DayForecast,
    val astro: Astro,
    val hour: List<HourlyForecast>
) : MapFromDataToDomain<ForecastDayEntity> {
    override fun map() =
        ForecastDayEntity(date, dateEpoch, day.map(), astro.map(), hour.map { it.map() })
}