package com.example.testproject.data.model

data class ProductResponse(

    val products: List<Product>
)

data class Product(
    val id: Int,
    val title: Int,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val thumbnail: String,
    val brand: String,
    val category: String,

    )