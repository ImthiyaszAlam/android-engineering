package com.imthiyas.shoppingcart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.shoppingcart.data.CartRepository
import com.imthiyas.shoppingcart.data.ProductRepository
import com.imthiyas.shoppingcart.model.Product
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CartViewModel(
    private val cartRepository: CartRepository,
    private val productRepository: ProductRepository
) : ViewModel() {


    val products = productRepository.getProducts()
    val cartItems = cartRepository.cartItems.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )


    fun addToCart(product: Product) {
        viewModelScope.launch {
            cartRepository.addToCart(product)
        }
    }

    fun increaseQuantity(id: Int) {
        viewModelScope.launch {
            cartRepository.changeQuantity(id, 1)
        }
    }

    fun decreaseQuantity(id: Int) {
        viewModelScope.launch {
            cartRepository.changeQuantity(id, -1)
        }
    }

    fun removeItem(id: Int) {
        viewModelScope.launch {
            cartRepository.removeItem(id)
        }
    }
}