package com.imthiyas.shopease.ui.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.imthiyas.shopease.data.remote.models.Product

@Composable
fun ProductGrid(
    products: List<Product>,
    favorites: Set<Int>,
    onFavoriteClick: (Int) -> Unit,
    onAddToCart: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                isFavorite = product.id in favorites,
                onFavoriteClick = {
                    onFavoriteClick(product.id)
                },
                onAddToCart = { onAddToCart(product.id) })
        }
    }

}