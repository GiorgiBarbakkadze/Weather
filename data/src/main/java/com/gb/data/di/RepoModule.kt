package com.gb.data.di

import com.gb.data.repository.RealTimeWeatherRepository
import org.koin.dsl.module

val repoModule = module {
    single { RealTimeWeatherRepository(get())}
}