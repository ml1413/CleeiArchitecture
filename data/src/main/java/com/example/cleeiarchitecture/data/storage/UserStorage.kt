package com.example.cleeiarchitecture.data.storage

import com.example.cleeiarchitecture.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User

}