package com.example.cleeiarchitecture.prezenation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleeiarchitecture.data.repository.UserRepositoryImpl
import com.example.cleeiarchitecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleeiarchitecture.databinding.ActivityMainBinding
import com.example.cleeiarchitecture.domain.models.SaveUserNameParam
import com.example.cleeiarchitecture.domain.models.UserName
import com.example.cleeiarchitecture.domain.use_case.GetUserNameUseCase
import com.example.cleeiarchitecture.domain.use_case.SaveUserNameUseCase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userStorage
            by lazy { SharedPrefsUserStorage(applicationContext) }
    private val userRepository
            by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(userStorage = userStorage) }
    private val getUserNameUseCase
            by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase
            by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.btSaveData.setOnClickListener {
            val text = binding.etPutData.text.toString()
            val param = SaveUserNameParam(
                firstName = text,
                lastName = ""
            )
            val result: Boolean = saveUserNameUseCase.execute(param = param)
            binding.tvText.text = "saveResult = $result"
        }

        binding.btGetData.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.tvText.text = "${userName.firstName} ${userName.lastname}"
        }
    }
}