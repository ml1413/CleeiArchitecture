package com.example.cleeiarchitecture.di

import android.content.Context
import com.example.cleeiarchitecture.data.repository.UserRepositoryImpl
import com.example.cleeiarchitecture.data.storage.UserStorage
import com.example.cleeiarchitecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleeiarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefsUserStorage(context = context)
    }
    @Provides
    fun provideUserRepositoryImpl(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}