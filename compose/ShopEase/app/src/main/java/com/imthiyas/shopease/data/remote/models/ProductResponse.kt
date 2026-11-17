package com.imthiyas.shopease.data.remote.models

import kotlinx.serialization.Serializable


@Serializable
data class ProductResponse(
    val products: List<Product>,
    val skip: Int,
    val total: Int,
    val limit: Int,
)
