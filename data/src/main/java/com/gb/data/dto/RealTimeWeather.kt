package com.gb.data.dto

import com.gb.data.dto.base.Current
import com.gb.data.dto.base.Location
import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.CurrentWeather
import com.squareup.moshi.Json

data class RealTimeWeather(
    val location: Location,
    val current: Current,
    @Json(name = "wind_mph") val windInMph: Float,
    @Json(name = "wind_kph") val windInKph: Float,
    @Json(name = "wind_degree") val windDirectionInDegrees: Float,
    @Json(name = "wind_dir") val windDirectionOnCompass: String,
    val humidity: Int,
    val cloud: Int,
    @Json(name = "feelslike_c") val feelsLikeInCelsius: Float,
    @Json(name = "feelslike_f") val feelsLikeInFahrenheit: Float,
    @Json(name = "uv") val ultravioletIndex: Float

): MapFromDataToDomain<CurrentWeather> {
    override fun map() = CurrentWeather(location.map(), current.map(), windInMph, windInKph, windDirectionInDegrees, windDirectionOnCompass, humidity, cloud, feelsLikeInCelsius, feelsLikeInFahrenheit, ultravioletIndex)
}
