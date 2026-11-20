package com.imthiyas.shoppingcart.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItem(

    @PrimaryKey(autoGenerate = true)
    val productId: Int,
    val productName: String,
    val pricePaise: Long,
    val quantity: Int

)