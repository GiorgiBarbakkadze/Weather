package com.gb.data.di

import com.gb.data.Constants.BASE_URL
import com.gb.data.network.WeatherApi
import com.gb.domain.common.ApiKeyProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkingModule = module {

    single {
//        GsonConverterFactory.create() as Converter.Factory
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory()) // Important for Kotlin support
            .build()
            .let { MoshiConverterFactory.create(it) as Converter.Factory }
    }
    single { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) as Interceptor }
    single {
        OkHttpClient.Builder().apply {
            addInterceptor(get())
                .callTimeout(10, TimeUnit.SECONDS)
        }.build()
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val newUrl = originalRequest.url() .newBuilder()// Use newBuilder()
                    .addQueryParameter("key", get<ApiKeyProvider>().getApiKey())
                    .build()
                val newRequest = originalRequest.newBuilder()
                    .url(newUrl) // Set the new URL
                    .build()
                chain.proceed(newRequest) // Proceed with the new request
            }
            .build()
    }
    single { provideApiKey(get()) }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(get())
            .build()
    }
    single { get<Retrofit>().create(WeatherApi::class.java) }

}

fun provideApiKey(apiKey: String): String {
    return apiKey
}
