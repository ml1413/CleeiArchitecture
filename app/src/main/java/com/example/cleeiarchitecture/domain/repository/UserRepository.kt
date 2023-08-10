package com.example.cleeiarchitecture.domain.repository

import com.example.cleeiarchitecture.domain.models.SaveUserNameParam
import com.example.cleeiarchitecture.domain.models.UserName

interface UserRepository {
    fun saveName(saveParams: SaveUserNameParam):Boolean
    fun getName(): UserName
}