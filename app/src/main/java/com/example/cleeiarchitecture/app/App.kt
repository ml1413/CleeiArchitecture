package com.example.cleeiarchitecture.app

import android.app.Application
import com.example.cleeiarchitecture.di.AppComponent
import com.example.cleeiarchitecture.di.AppModule
import com.example.cleeiarchitecture.di.DaggerAppComponent


class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(
                AppModule(context = this)
            )
            .build()
    }
}