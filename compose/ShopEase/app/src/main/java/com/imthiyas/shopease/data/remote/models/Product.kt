package com.imthiyas.shopease.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val brand: String?,
    val price: String,
    val discountPercentage: String,
    val rating: String,
)
