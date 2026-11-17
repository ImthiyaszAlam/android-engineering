package com.imthiyas.shopease.ui.screens.home

import com.imthiyas.shopease.data.remote.models.Category
import com.imthiyas.shopease.data.remote.models.Product

data class HomeUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val categories: List<Category> = emptyList(),
    val searchQuery: String = "",
    val selectedCategory: String = "all",
    val error: String? = null
)