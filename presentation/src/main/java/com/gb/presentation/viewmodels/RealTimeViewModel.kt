package com.gb.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gb.domain.common.Result
import com.gb.domain.entities.WeatherEntity
import com.gb.domain.usecases.GetRealtimeWeatherUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class RealTimeViewModel(private val getRealtimeWeatherUseCase: GetRealtimeWeatherUseCase): ViewModel() {

    private var _realTimeWeatherSharedFlow = MutableSharedFlow<Result<WeatherEntity>>()
    val realTimeWeatherSharedFlow: SharedFlow<Result<WeatherEntity>> get() = _realTimeWeatherSharedFlow


    init {
       getRealTimeWeather("tbilisi")
    }

    fun getRealTimeWeather(location: String) {

        viewModelScope.launch {
            _realTimeWeatherSharedFlow.emit(Result.Loading)
            getRealtimeWeatherUseCase.executeUseCase(location).collect {
                _realTimeWeatherSharedFlow.emit(it)
            }
        }
    }
}