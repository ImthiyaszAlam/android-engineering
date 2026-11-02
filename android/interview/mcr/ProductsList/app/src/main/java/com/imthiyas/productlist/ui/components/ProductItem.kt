package com.imthiyas.productlist.ui.components

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.imthiyas.productlist.data.model.Product


@Composable
fun ProductItem(product: Product) {

    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {

        Column() {

            AsyncImage(
                model = product.images,
                contentDescription = product.title,
                modifier = Modifier.height(130.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = product.title)
            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "${product.price}")
            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "${product.rating}")
        }

    }
}