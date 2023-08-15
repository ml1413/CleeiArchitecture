package com.example.cleeiarchitecture.di

import com.example.cleeiarchitecture.domain.repository.UserRepository
import com.example.cleeiarchitecture.domain.use_case.GetUserNameUseCase
import com.example.cleeiarchitecture.domain.use_case.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }
}

