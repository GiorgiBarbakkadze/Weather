package com.gb.weather

import android.app.Application
import com.gb.data.di.networkingModule
import com.gb.data.di.repoModule
import com.gb.domain.di.useCaseModule
import com.gb.presentation.di.presentationModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level


//val allModules = listOf(prModule, domainModule, dataModules)
//networkingModule, repoModule, useCaseModule, presentationModule


class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(prModule + domainModule + dataModules)
        }
    }
}
val dataModules = listOf(repoModule, networkingModule)
val domainModule = listOf(useCaseModule)
val prModule = listOf(presentationModule)
