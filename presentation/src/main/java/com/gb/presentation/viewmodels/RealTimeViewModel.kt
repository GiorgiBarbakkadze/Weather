package com.gb.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.domain.common.Result
import com.gb.domain.entities.CurrentWeather
import com.gb.domain.usecases.GetRealtimeWeatherUseCase

class RealTimeViewModel(private val getRealtimeWeatherUseCase: GetRealtimeWeatherUseCase): BaseViewModel() {
    private val _realtimeWeather: MutableLiveData<Result<CurrentWeather>> = MutableLiveData()
    val realtimeWeather: LiveData<Result<CurrentWeather>>
        get() = _realtimeWeather

    fun getRealtimeWeather() {
        executeUseCase {
            _realtimeWeather.value = getRealtimeWeatherUseCase.getRealtimeWeather()
        }
    }
}