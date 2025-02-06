package com.gb.presentation.viewmodels

import com.gb.domain.common.Result
import com.gb.domain.entities.CurrentWeather
import com.gb.domain.usecases.GetRealtimeWeatherUseCase
import kotlinx.coroutines.flow.MutableSharedFlow

class RealTimeViewModel(private val getRealtimeWeatherUseCase: GetRealtimeWeatherUseCase): BaseViewModel() {


    private var _realtimeWeather = MutableSharedFlow<Result<CurrentWeather>>()
    val realtimeWeather get() = _realtimeWeather


    fun getRealtimeWeather() {
        executeUseCase(_realtimeWeather) {
            getRealtimeWeatherUseCase.executeUseCase()
        }
    }
}