package com.example.cleeiarchitecture.prezenation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleeiarchitecture.domain.models.SaveUserNameParam
import com.example.cleeiarchitecture.domain.models.UserName
import com.example.cleeiarchitecture.domain.use_case.GetUserNameUseCase
import com.example.cleeiarchitecture.domain.use_case.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {
    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable


    init {
        Log.e("TAG1", "vm created")
    }

    override fun onCleared() {
        Log.e("TAG1", "vm created")
        super.onCleared()
    }

    fun save(text: String) {
        val param = SaveUserNameParam(
            firstName = text,
            lastName = ""
        )
        resultLiveMutable.value = "save result ${saveUserNameUseCase.execute(param = param)}"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastname}"
    }
}