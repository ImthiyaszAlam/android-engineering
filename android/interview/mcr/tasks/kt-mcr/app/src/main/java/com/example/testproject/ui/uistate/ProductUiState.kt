package com.example.testproject.ui.uistate

import com.example.testproject.data.model.Product
import com.example.testproject.data.model.ProductResponse

sealed interface ProductUiState {

    data object Loading : ProductUiState
    data class Success(
        val products: ProductResponse = List<Product>
    ) : ProductUiState

    data class Error(
        val error: String
    ) : ProductUiState
}