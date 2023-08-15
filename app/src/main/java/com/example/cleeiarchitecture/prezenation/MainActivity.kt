package com.example.cleeiarchitecture.prezenation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cleeiarchitecture.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        Log.e("TAG1", "onCreate: ActivityCreated")

        viewModel.resultLive.observe(this) {
            binding.tvText.text = it
        }
        binding.btSaveData.setOnClickListener {
            val text = binding.etPutData.text.toString()
            viewModel.save(text = text)
        }

        binding.btGetData.setOnClickListener {
            viewModel.load()
        }
    }
}