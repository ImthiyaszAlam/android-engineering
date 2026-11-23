package com.imthiyas.shopease.ui.vm

import androidx.lifecycle.ViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CartViewModel @Inject constructor() : ViewModel() {

    private val _cart = MutableStateFlow<Set<Int>>(emptySet())
    val cart = _cart.asStateFlow()


    fun addToCart(productId: Int) {
        _cart.update { current ->
            current + productId

        }

    }

}