package com.example.testproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.data.repository.ProductRepository
import com.example.testproject.ui.uistate.ProductUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)

    val uiState = _uiState.asStateFlow()

    var limit = 20
    val skip = 0;

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.let {


            try {

                _uiState.value = ProductUiState.Loading


                viewModelScope.launch {
                    val response = repository.getProducts(limit, skip)
                    _uiState.value = ProductUiState.Success(response)
                }


            } catch (e: Exception) {
                _uiState.value = ProductUiState.Error(
                    e.message ?: "Something went wrong !"
                )
            }
        }
    }
}