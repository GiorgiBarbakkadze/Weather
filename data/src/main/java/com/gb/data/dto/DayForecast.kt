package com.gb.data.dto

import com.gb.data.dto.base.Condition
import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.DayForecastEntity
import com.squareup.moshi.Json

data class DayForecast(
    @Json(name = "maxtemp_c") val maxTempC: Double,
    @Json(name = "maxtemp_f") val maxTempF: Double,
    @Json(name = "mintemp_c") val minTempC: Double,
    @Json(name = "mintemp_f") val minTempF: Double,
    @Json(name = "avgtemp_c") val avgTempC: Double,
    @Json(name = "avgtemp_f") val avgTempF: Double,
    @Json(name = "maxwind_mph") val maxWindMph: Double,
    @Json(name = "maxwind_kph") val maxWindKph: Double,
    @Json(name = "totalprecip_mm") val totalPrecipMm: Double,
    @Json(name = "totalprecip_in") val totalPrecipIn: Double,
    @Json(name = "totalsnow_cm") val totalSnowCm: Double,
    @Json(name = "avgvis_km") val avgVisKm: Double,
    @Json(name = "avgvis_miles") val avgVisMiles: Double,
    @Json(name = "avghumidity") val avgHumidity: Int,
    @Json(name = "daily_will_it_rain") val dailyWillItRain: Int,
    @Json(name = "daily_chance_of_rain") val dailyChanceOfRain: Int,
    @Json(name = "daily_will_it_snow") val dailyWillItSnow: Int,
    @Json(name = "daily_chance_of_snow") val dailyChanceOfSnow: Int,
    val condition: Condition,
    val uv: Double
) : MapFromDataToDomain<DayForecastEntity> {
    override fun map() = DayForecastEntity(
        maxTempC,
        minTempC,
        avgTempC,
        maxWindKph,
        totalSnowCm,
        avgHumidity,
        dailyWillItRain,
        dailyChanceOfRain,
        dailyWillItSnow,
        dailyChanceOfSnow,
        condition.map(),
        uv
    )
}