package com.imthiyas.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imthiyas.shoppingcart.data.CartDatabase
import com.imthiyas.shoppingcart.data.CartRepository
import com.imthiyas.shoppingcart.data.ProductRepository
import com.imthiyas.shoppingcart.ui.screens.ShoppingCartScreen
import com.imthiyas.shoppingcart.ui.theme.ShoppingCartTheme
import com.imthiyas.shoppingcart.viewmodel.CartViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                val viewModel: CartViewModel = viewModel(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            val database = CartDatabase.getDatabase(applicationContext)
                            val cartRepository = CartRepository(database.cartDao())
                            val productRepository = ProductRepository()
                            @Suppress("UNCHECKED_CAST")
                            return CartViewModel(cartRepository, productRepository) as T
                        }
                    }
                )
                ShoppingCartScreen(viewModel = viewModel)
            }
        }
    }
}