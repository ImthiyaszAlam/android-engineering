package com.imthiyas.weatherapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.imthiyas.weatherapp.R
import com.imthiyas.weatherapp.domain.model.Weather
import com.imthiyas.weatherapp.data.repository.WeatherRepository
import com.imthiyas.weatherapp.util.Resource
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val repository = WeatherRepository()
        val factory = WeatherViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[WeatherViewModel::class.java]

        viewModel.weather.observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> Log.d("WeatherApp", "Loading...")
                is Resource.Success -> {
                    Log.d(
                        "WeatherApp",
                        "City: ${resource.data?.name}, Temp: ${resource.data?.main?.temp}"
                    )
                }

                is Resource.Error -> Log.e("WeatherApp", "Error: ${resource.message}")
            }
        }

        viewModel.fetchWeather("Delhi")
        viewModel.fetchWeather("Mumbai")
        viewModel.fetchWeather("Kolkata")
        viewModel.fetchWeather("Assam")


    }
}