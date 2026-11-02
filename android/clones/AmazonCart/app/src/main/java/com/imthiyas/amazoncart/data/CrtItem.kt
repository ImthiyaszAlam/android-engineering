package com.imthiyas.amazoncart.data

data class CrtItem(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val price: Double,
    val inStock: Boolean = true,
    val isPrime: Boolean = true,
    val qty: Int = 1
)