package com.imthiyas.productlist.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.productlist.data.repository.ProductRepository
import com.imthiyas.productlist.ui.uistate.ProductUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {


    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private var pageSize = 20
    private var skip = 0
    private var total = 100

    init {
        getProducts()
    }

    fun getProducts() {

        if (_uiState.value !is ProductUiState.Loading &&
            _uiState.value !is ProductUiState.Error
        ) return


        viewModelScope.launch {

            _uiState.value = ProductUiState.Loading
            try {
                val response = repository.getProducts(pageSize, skip)
                skip += response.products.size
                _uiState.value = ProductUiState.Success(
                    products = response.products,
                    hasMore = skip < response.total
                )

            } catch (e: Exception) {
                _uiState.value = ProductUiState.Error(
                    e.message ?: "Something went wrong!"
                )


            }
        }
    }

}