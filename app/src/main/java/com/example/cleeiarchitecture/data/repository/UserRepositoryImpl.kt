package com.example.cleeiarchitecture.data.repository

import com.example.cleeiarchitecture.data.storage.UserStorage
import com.example.cleeiarchitecture.data.storage.models.User
import com.example.cleeiarchitecture.domain.models.SaveUserNameParam
import com.example.cleeiarchitecture.domain.models.UserName
import com.example.cleeiarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveParams: SaveUserNameParam): Boolean {
        val user: User = mapToStorage(saveParams)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }
//////////////////////////////////////////////////////q
    private fun mapToStorage(saveParams: SaveUserNameParam): User {
        return User(firstName = saveParams.firstName, lastName = saveParams.lastName)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastname = user.lastName)
    }
}