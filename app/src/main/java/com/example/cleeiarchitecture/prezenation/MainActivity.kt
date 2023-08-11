package com.example.cleeiarchitecture.prezenation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleeiarchitecture.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        Log.e("TAG1", "onCreate: ActivityCreated")
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

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