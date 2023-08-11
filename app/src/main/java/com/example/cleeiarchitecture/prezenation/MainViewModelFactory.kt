package com.example.cleeiarchitecture.prezenation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleeiarchitecture.data.repository.UserRepositoryImpl
import com.example.cleeiarchitecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleeiarchitecture.domain.use_case.GetUserNameUseCase
import com.example.cleeiarchitecture.domain.use_case.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userStorage
            by lazy { SharedPrefsUserStorage(context = context) }
    private val userRepository
            by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(userStorage = userStorage) }
    private val getUserNameUseCase
            by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase
            by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }


}