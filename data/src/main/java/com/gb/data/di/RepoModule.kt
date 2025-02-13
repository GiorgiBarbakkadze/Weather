package com.gb.data.di

import com.gb.data.repository.WeatherRepository
import com.gb.domain.repositories.CurrentWeatherRepo
import org.koin.dsl.module

val repoModule = module {
    factory<CurrentWeatherRepo>{ WeatherRepository(get())}
}