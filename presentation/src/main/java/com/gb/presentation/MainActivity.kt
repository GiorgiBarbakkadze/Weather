package com.gb.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gb.domain.common.Result
import com.gb.presentation.databinding.ActivityMainBinding
import com.gb.presentation.viewmodels.RealTimeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel: RealTimeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.click.setOnClickListener {
            lifecycleScope.launch {
                viewModel.getRealtimeWeather()
            }
        }
        observeDta()

    }

    private fun observeDta() {
        lifecycleScope.launch {
            viewModel.realtimeWeather.collectLatest {
                when (it) {
                    is Result.Success -> {
                        Log.d("haha", "observeDta: ${it.data}")
                    }

                    is Result.Error -> {
                        Log.d("haha", "observeDta: ${it.exception} ${it.errorMessage}")
                    }
                }
            }
        }
    }

}











