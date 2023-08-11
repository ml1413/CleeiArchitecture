package com.example.cleeiarchitecture.data.storage.sharedprefs

import android.content.Context
import com.example.cleeiarchitecture.data.storage.UserStorage
import com.example.cleeiarchitecture.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_prebs_name"
private const val KEY_NAME_FIRSTNAME = "first name"
private const val KEY_NAME_LASTNAME = "lastname name"
private const val DEF_FIRST_NAME = "Default first name"
private const val DEF_LAST_NAME = "Default last name"

class SharedPrefsUserStorage(context: Context) : UserStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_NAME_FIRSTNAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_NAME_LASTNAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName =
            sharedPreferences.getString(KEY_NAME_FIRSTNAME, DEF_FIRST_NAME) ?: DEF_FIRST_NAME
        val lastName =
            sharedPreferences.getString(KEY_NAME_LASTNAME, DEF_LAST_NAME) ?: DEF_LAST_NAME
        return User(firstName = firstName, lastName = lastName)
    }
}