package com.example.cleeiarchitecture.di

import android.content.Context
import com.example.cleeiarchitecture.data.repository.UserRepositoryImpl
import com.example.cleeiarchitecture.data.storage.UserStorage
import com.example.cleeiarchitecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleeiarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefsUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}
