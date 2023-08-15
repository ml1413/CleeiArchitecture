package com.example.cleeiarchitecture.di

import com.example.cleeiarchitecture.prezenation.MainActivity
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}