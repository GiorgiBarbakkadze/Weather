package com.gb.weather

import android.app.Application
import com.gb.data.di.networkingModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext


class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModules)
        }
    }
}
val dataModules = listOf(networkingModule)