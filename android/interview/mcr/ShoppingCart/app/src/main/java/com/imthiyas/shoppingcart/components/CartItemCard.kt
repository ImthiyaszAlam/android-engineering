package com.imthiyas.shoppingcart.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.imthiyas.shoppingcart.model.CartItem
import com.imthiyas.shoppingcart.util.formatPrice

@Composable
 fun CartItemCard(
    item: CartItem,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onRemove: () -> Unit
) {
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Text(item.productName, style = MaterialTheme.typography.titleMedium)
            Text("${formatPrice(item.pricePaise)} each")

            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                OutlinedButton(onClick = onDecrease) {
                    Text("−")
                }

                Text(
                    text = " ${item.quantity} ",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                OutlinedButton(onClick = onIncrease) {
                    Text("+")
                }

                Spacer(Modifier.weight(1f))

                TextButton(onClick = onRemove) {
                    Text("Remove")
                }
            }

            Text("Subtotal: ${formatPrice(item.pricePaise * item.quantity)}")
        }
    }
}