package com.gb.data.dto

import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.AirQualityEntity
import com.squareup.moshi.Json

data class AirQuality(
    @Json(name = "co") val carbonMonoxide: Double,
    @Json(name = "no2") val nitrogenDioxide: Double,
    @Json(name = "o3") val ozone: Double,
    @Json(name = "so2") val sulfurDioxide: Double,
    @Json(name = "pm2_5") val particulateMatter2_5: Double,
    @Json(name = "pm10") val particulateMatter10: Double,
    @Json(name = "us-epa-index") val usEpaIndex: Int,
    @Json(name = "gb-defra-index") val gbDefraIndex: Int
) : MapFromDataToDomain<AirQualityEntity> {
    override fun map() = AirQualityEntity(
        carbonMonoxide,
        nitrogenDioxide,
        ozone,
        sulfurDioxide,
        particulateMatter2_5,
        usEpaIndex
    )
}
