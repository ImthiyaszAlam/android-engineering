package com.example.testproject.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.testproject.data.model.Product

@Composable
fun ProductItem(product: Product) {

    Column() {
        AsyncImage(
            modifier = Modifier.height(70.dp),
            model = product.thumbnail,
            contentDescription = "Image"
        )

        Text(text = "${product.title}")

        Column() {

            Row(modifier = Modifier.weight(1f)) {

                Text(text = "${product.title}")
                Text(text = "${product.price}")
                Text(text = "${product.discountPercentage}")
                Text(text = "${product.rating}")

            }

            Button(
                onClick = {}
            ) {
                Icon(imageVector = Icons())
            }
        }
    }
}