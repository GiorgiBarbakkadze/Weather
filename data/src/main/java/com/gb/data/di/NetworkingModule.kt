package com.gb.data.di

import com.gb.data.Constants.BASE_URL
import com.gb.data.network.WeatherApi
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
//    single { MoshiConverterFactory.create() as MoshiConverterFactory }
////    single { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }
//    single { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) as Interceptor }
//
//    single {
//        OkHttpClient.Builder().apply {
//            addInterceptor { get() }.callTimeout(10, TimeUnit.SECONDS)
//        }
//    }
////    single {
////        OkHttpClient
////            .Builder()
////            .connectTimeout(10, TimeUnit.SECONDS)
////            .readTimeout(10, TimeUnit.SECONDS)
////            .writeTimeout(10, TimeUnit.SECONDS)
////            .addInterceptor(
////                HttpLoggingInterceptor()
////                    .apply { level = HttpLoggingInterceptor.Level.BODY},
////            ).build()
////    }
//
//    single {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(get())
//            .addConverterFactory(get())
//            .build()
//    }
//    single {get<Retrofit>().create(WeatherApi::class.java)}

//    single { MoshiConverterFactory.create() as MoshiConverterFactory }
    single { GsonConverterFactory.create() as Converter.Factory }
//
    single { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) as Interceptor }
    single {
        OkHttpClient.Builder().apply {
            addInterceptor(get())
                .callTimeout(10, TimeUnit.SECONDS)
        }.build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(get())
            .build()
    }
    single { get<Retrofit>().create(WeatherApi::class.java) }


}
fun provideInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}
