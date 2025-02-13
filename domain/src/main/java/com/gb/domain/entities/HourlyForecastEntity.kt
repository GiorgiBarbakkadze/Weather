package com.gb.domain.entities

import com.gb.domain.entities.base.ConditionEntity

data class HourlyForecastEntity(
    val timeEpoch: Long,
    val time: String,
    val tempC: Double,
    val isDay: Int,
    val condition: ConditionEntity,
    val windKph: Double,
    val windDegree: Int,
    val windDir: String,
    val snowCm: Double,
    val humidity: Int,
    val cloud: Int,
    val feelsLikeC: Double,
    val windChillC: Double,
    val heatIndexC: Double,
    val dewPointC: Double,
    val dewPointF: Double,
    val willItRain: Int,
    val chanceOfRain: Int,
    val willItSnow: Int,
    val chanceOfSnow: Int,
    val uv: Double
)