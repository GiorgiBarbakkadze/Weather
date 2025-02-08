package com.gb.data.dto.base

import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.base.CurrentEntity
import com.squareup.moshi.Json

data class Current(
    @Json(name = "last_updated_epoch") val localTimeWhenRealTimeUpdatedUnix: Int,
    @Json(name = "last_updated") val localTimeWhenRealTimeUpdated: String,
    @Json(name = "temp_c") val temperatureInCelsius: Float,
    @Json(name = "temp_f") val temperatureInFahrenheit: Float,
    @Json(name = "is_day") val isDayOrNight: Int,
    val condition: Condition,
    @Json(name = "wind_mph") val windInMph: Float,
    @Json(name = "wind_kph") val windInKph: Float,
    @Json(name = "wind_degree") val windDirectionInDegrees: Float,
    @Json(name = "wind_dir") val windDirectionOnCompass: String,
    val humidity: Int,
    val cloud: Int,
    @Json(name = "feelslike_c") val feelsLikeInCelsius: Float,
    @Json(name = "feelslike_f") val feelsLikeInFahrenheit: Float,
    @Json(name = "uv") val ultravioletIndex: Float

) : MapFromDataToDomain<CurrentEntity> {
    override fun map() = CurrentEntity(
        localTimeWhenRealTimeUpdatedUnix,
        localTimeWhenRealTimeUpdated,
        temperatureInCelsius,
        temperatureInFahrenheit,
        isDayOrNight,
        condition.map(),
        windInMph,
        windInKph,
        windDirectionInDegrees,
        windDirectionOnCompass,
        humidity,
        cloud,
        feelsLikeInCelsius,
        feelsLikeInFahrenheit,
        ultravioletIndex
    )
}