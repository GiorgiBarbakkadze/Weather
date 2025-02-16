package com.gb.domain.entities
import java.io.Serializable



data class AirQualityEntity(
    val carbonMonoxide: Double,
    val nitrogenDioxide: Double,
    val ozone: Double,
    val sulfurDioxide: Double,
    val particulateMatter2_5: Double,
    val useEpaIndex: Int
): Serializable

