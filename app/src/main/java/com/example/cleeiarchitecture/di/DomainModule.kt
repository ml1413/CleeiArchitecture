package com.example.cleeiarchitecture.di

import com.example.cleeiarchitecture.domain.use_case.GetUserNameUseCase
import com.example.cleeiarchitecture.domain.use_case.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}