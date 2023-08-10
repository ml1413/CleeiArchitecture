package com.example.cleeiarchitecture.domain.use_case

import com.example.cleeiarchitecture.domain.models.UserName
import com.example.cleeiarchitecture.domain.repository.UserRepository

class GetUserNameUseCase ( private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}