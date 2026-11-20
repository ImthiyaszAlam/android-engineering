package com.imthiyas.productlist.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("products")
    val products: List<Product>,

    @SerializedName("total")
    val total: Int,

    @SerializedName("skip")
    val skip: Int,

    @SerializedName("limit")
    val limit: Int
)

data class Product(

    @SerializedName("id")
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val images: String

)
