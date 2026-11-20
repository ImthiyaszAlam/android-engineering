package com.imthiyas.productlist.ui.uistate

import android.os.Message
import com.imthiyas.productlist.data.model.Product
import com.imthiyas.productlist.data.model.ProductResponse

sealed interface ProductUiState {

    data object Loading : ProductUiState

    data class Success(
        val products: List<Product> = emptyList(),
        val isLoadingMore: Boolean = false,
        val hasMore: Boolean = true,
        val paginationError: String? = null
    ) : ProductUiState

    data class Error(
        val message: String
    ) : ProductUiState


}