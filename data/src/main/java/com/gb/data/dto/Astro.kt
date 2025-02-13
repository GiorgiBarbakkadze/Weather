package com.gb.data.dto

import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.AstroEntity
import com.squareup.moshi.Json

data class Astro(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    @Json(name = "moon_phase") val moonPhase: String,
    @Json(name = "moon_illumination") val moonIllumination: Int,
    @Json(name = "is_moon_up") val isMoonUp: Int,
    @Json(name = "is_sun_up") val isSunUp: Int
) : MapFromDataToDomain<AstroEntity> {
    override fun map() = AstroEntity(
        sunrise,
        sunset,
        moonrise,
        moonset,
        moonPhase,
        moonIllumination,
        isMoonUp,
        isSunUp
    )
}