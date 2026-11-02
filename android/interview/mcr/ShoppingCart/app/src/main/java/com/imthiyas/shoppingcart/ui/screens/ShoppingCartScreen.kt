package com.imthiyas.shoppingcart.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.imthiyas.shoppingcart.components.CartItemCard
import com.imthiyas.shoppingcart.components.ProductCard
import com.imthiyas.shoppingcart.util.formatPrice
import com.imthiyas.shoppingcart.viewmodel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(
    viewModel: CartViewModel
) {

    val cartItems by viewModel.cartItems.collectAsStateWithLifecycle()
    val total = cartItems.sumOf {
        it.pricePaise * it.quantity
    }


    Scaffold(
        topBar = { TopAppBar(title = { Text("Cart Screen") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { Text("Products", style = MaterialTheme.typography.bodyMedium) }
            items(
                viewModel.products,
                key = { "product_${it.id}" })
            { product ->
                ProductCard(
                    product = product,
                    onAdd = { viewModel.addToCart(product) }
                )
            }

            item {
                HorizontalDivider()

                Text(
                    "Your Cart (${cartItems.sumOf { it.quantity }} items)",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            if (cartItems.isEmpty()) {
                item {
                    Text("Your cart is empty. Add a product to get started.")
                }
            } else {
                items(
                    cartItems,
                    key = { "cart_${it.productId}" }) { item ->
                    CartItemCard(
                        item = item,
                        onIncrease = {
                            viewModel.increaseQuantity(item.productId)
                        },
                        onDecrease = {
                            viewModel.decreaseQuantity(item.productId)
                        },
                        onRemove = {
                            viewModel.removeItem(item.productId)
                        }
                    )
                }

                item {
                    HorizontalDivider()

                    Text(
                        "Total: ${formatPrice(total)}",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }


        }


    }

}