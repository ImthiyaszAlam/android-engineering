package com.imthiyas.weatherapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.weatherapp.domain.model.WeatherResponse
import com.imthiyas.weatherapp.data.repository.WeatherRepository
import com.imthiyas.weatherapp.util.Resource
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private var _weather = MutableLiveData<Resource<WeatherResponse>>()
    val weather: LiveData<Resource<WeatherResponse>> = _weather

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            _weather.postValue(Resource.Loading())

            try {
                val response = repository.getWeather(city)
                _weather.postValue(Resource.Success(response))
            } catch (e: Exception) {
                _weather.postValue(Resource.Error(e.message ?: "An Unknown Error Occured"))
            }
        }
    }
}