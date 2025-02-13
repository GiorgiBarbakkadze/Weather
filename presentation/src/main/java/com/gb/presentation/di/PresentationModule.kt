package com.gb.presentation.di

import com.gb.domain.usecases.GetRealtimeWeatherUseCase
import com.gb.presentation.mainweather.RealTimeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {
    viewModel { RealTimeViewModel(get()) }
    single {GetRealtimeWeatherUseCase(get())}
}