package com.example.cleeiarchitecture.app

import android.app.Application
import com.example.cleeiarchitecture.di.appModule
import com.example.cleeiarchitecture.di.dataModule
import com.example.cleeiarchitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}