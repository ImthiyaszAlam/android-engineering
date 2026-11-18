package com.imthiyas.shopease.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.imthiyas.shopease.data.remote.models.Product

@Composable
fun DealBanner(product: Product) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "SPECIAL DEAL", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = product.title,
                color = Color.White,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = product.discountPercentage.toString(),
                color = Color.White,
                style = MaterialTheme.typography.labelLarge
            )

        }


    }
}