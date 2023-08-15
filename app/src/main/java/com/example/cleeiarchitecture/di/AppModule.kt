package com.example.cleeiarchitecture.di

import android.content.Context
import com.example.cleeiarchitecture.domain.use_case.GetUserNameUseCase
import com.example.cleeiarchitecture.domain.use_case.SaveUserNameUseCase
import com.example.cleeiarchitecture.prezenation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }
    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }
}