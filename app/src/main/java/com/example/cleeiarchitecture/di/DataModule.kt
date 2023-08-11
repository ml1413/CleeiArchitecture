package com.example.cleeiarchitecture.di

import com.example.cleeiarchitecture.data.repository.UserRepositoryImpl
import com.example.cleeiarchitecture.data.storage.UserStorage
import com.example.cleeiarchitecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleeiarchitecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefsUserStorage(context = get())
    }
    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}