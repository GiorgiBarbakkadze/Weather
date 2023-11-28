package com.gb.data.di

import com.gb.data.repository.RealTimeWeatherRepository
import com.gb.domain.repositories.CurrentWeatherRepo
import org.koin.dsl.module

val repoModule = module {
    factory<CurrentWeatherRepo>{ RealTimeWeatherRepository(get())}
}