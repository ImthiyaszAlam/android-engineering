package com.imthiyas.shopease.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val slug: String,
    val name: String,
    val url: String,
)
