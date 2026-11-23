package com.imthiyas.shopease.ui.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.imthiyas.shopease.data.remote.models.Product
import org.jetbrains.annotations.Async

@Composable
fun ProductCard(
    product: Product,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {


            AsyncImage(
                model = product.thumbnail,
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )

            Text(
                text = product.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2
            )


            Text(
                text = "${product.price}% OFF",
                color = Color(0xFF2E7D32)
            )

            Text(
                text = "${product.discountPercentage}% OFF",
                color = Color(0xFF2E7D32)
            )

            IconButton(onClick = onFavoriteClick) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favourite Toggle?",
                    tint = if (isFavorite) Color.Red else Color.Gray
                )
            }


        }

    }
}