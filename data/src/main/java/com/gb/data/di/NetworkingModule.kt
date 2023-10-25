package com.gb.data.di

import com.gb.data.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

val networkingModule = module {
    single { MoshiConverterFactory.create() as MoshiConverterFactory }
    single { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }
    single {
        OkHttpClient.Builder().apply {
            addInterceptor { get() }.callTimeout(10, TimeUnit.SECONDS)
        }
    }
    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(get())
            .addConverterFactory(get())
            .build()
    }
    single {get<Retrofit>().create(WeatherApi::class.java)}
}
