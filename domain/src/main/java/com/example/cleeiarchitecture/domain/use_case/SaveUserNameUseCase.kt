package com.example.cleeiarchitecture.domain.use_case

import com.example.cleeiarchitecture.domain.models.SaveUserNameParam
import com.example.cleeiarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase (private val userRepository: UserRepository){
    fun execute(param: SaveUserNameParam): Boolean {
       val result :Boolean = userRepository.saveName(saveParams = param)
        return result
    }
}