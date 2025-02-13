package com.gb.data.dto

import com.gb.data.dto.base.Condition
import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.HourlyForecastEntity
import com.squareup.moshi.Json

data class HourlyForecast(
    @Json(name = "time_epoch") val timeEpoch: Long,
    val time: String,
    @Json(name = "temp_c") val tempC: Double,
    @Json(name = "temp_f") val tempF: Double,
    @Json(name = "is_day") val isDay: Int,
    val condition: Condition,
    @Json(name = "wind_mph") val windMph: Double,
    @Json(name = "wind_kph") val windKph: Double,
    @Json(name = "wind_degree") val windDegree: Int,
    @Json(name = "wind_dir") val windDir: String,
    @Json(name = "pressure_mb") val pressureMb: Double,
    @Json(name = "pressure_in") val pressureIn: Double,
    @Json(name = "precip_mm") val precipMm: Double,
    @Json(name = "precip_in") val precipIn: Double,
    @Json(name = "snow_cm") val snowCm: Double,
    val humidity: Int,
    val cloud: Int,
    @Json(name = "feelslike_c") val feelsLikeC: Double,
    @Json(name = "feelslike_f") val feelsLikeF: Double,
    @Json(name = "windchill_c") val windChillC: Double,
    @Json(name = "windchill_f") val windChillF: Double,
    @Json(name = "heatindex_c") val heatIndexC: Double,
    @Json(name = "heatindex_f") val heatIndexF: Double,
    @Json(name = "dewpoint_c") val dewPointC: Double,
    @Json(name = "dewpoint_f") val dewPointF: Double,
    @Json(name = "will_it_rain") val willItRain: Int,
    @Json(name = "chance_of_rain") val chanceOfRain: Int,
    @Json(name = "will_it_snow") val willItSnow: Int,
    @Json(name = "chance_of_snow") val chanceOfSnow: Int,
    @Json(name = "vis_km") val visKm: Double,
    @Json(name = "vis_miles") val visMiles: Double,
    @Json(name = "gust_mph") val gustMph: Double,
    @Json(name = "gust_kph") val gustKph: Double,
    val uv: Double
) : MapFromDataToDomain<HourlyForecastEntity> {
    override fun map() = HourlyForecastEntity(
        timeEpoch,
        time,
        tempC,
        isDay,
        condition.map(),
        windKph,
        windDegree,
        windDir,
        snowCm,
        humidity,
        cloud,
        feelsLikeC,
        windChillC,
        heatIndexC,
        dewPointC,
        dewPointF,
        willItRain,
        chanceOfRain,
        willItSnow,
        chanceOfSnow,
        uv
    )
}