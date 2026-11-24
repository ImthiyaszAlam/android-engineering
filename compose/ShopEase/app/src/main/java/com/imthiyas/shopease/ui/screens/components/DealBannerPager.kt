package com.imthiyas.shopease.ui.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.imthiyas.shopease.data.remote.models.Product

@Composable
fun DealBannerPager(products: List<Product>) {

    val pageState = rememberPagerState(
        pageCount = { products.size }
    )

    HorizontalPager(
        state = pageState,
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        DealBanner(product = products[page])
    }

}