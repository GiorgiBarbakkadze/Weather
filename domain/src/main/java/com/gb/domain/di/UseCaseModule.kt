package com.gb.domain.di

import com.gb.domain.usecases.GetRealtimeWeatherUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {GetRealtimeWeatherUseCase(get())}
}