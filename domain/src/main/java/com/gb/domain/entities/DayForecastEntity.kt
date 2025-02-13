package com.gb.domain.entities

import com.gb.domain.entities.base.ConditionEntity

data class DayForecastEntity(
    val maxTempC: Double,
    val minTempC: Double,
    val avgTempC: Double,
    val maxWindKph: Double,
    val totalSnowCm: Double,
    val avgHumidity: Int,
    val dailyWillItRain: Int,
    val dailyChanceOfRain: Int,
    val dailyWillItSnow: Int,
    val dailyChanceOfSnow: Int,
    val condition: ConditionEntity,
    val uv: Double
)