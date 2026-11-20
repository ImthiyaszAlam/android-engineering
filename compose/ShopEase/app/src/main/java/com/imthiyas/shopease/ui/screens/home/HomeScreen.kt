package com.imthiyas.shopease.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.imthiyas.shopease.ui.screens.components.CategorySection
import com.imthiyas.shopease.ui.screens.components.DealBanner
import com.imthiyas.shopease.ui.screens.components.HomeHeader
import com.imthiyas.shopease.ui.screens.components.ProductGrid
import com.imthiyas.shopease.ui.screens.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    Scaffold(topBar = {
        HomeHeader()
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            SearchBar(
                query = uiState.searchQuery,
                onQueryChange = { viewModel.onSearchQueryChange(it) }
            )

            val bestDeal = uiState.products.maxByOrNull {
                it.discountPercentage
            }

            bestDeal?.let {
                DealBanner(product = it)
            }

            CategorySection(
                categories = uiState.categories,
                selectedCategory = uiState.selectedCategory,
                onCategorySelected = viewModel::onCategorySelected
            )

            ProductGrid(products = viewModel.getFilteredProducts())

        }

    }

    /*   if (uiState.isLoading) {

           Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               CircularProgressIndicator()
           }

       } else if (uiState.error != null) {
           Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
           )
           {
               Text(text = uiState.error ?: "Something went wrong !")
               Button(onClick = { viewModel.retry() }) {
                   Text(text = "Retry")
               }
           }

       } else if (uiState.products.isEmpty()) {
           Text(text = "No products found")
       } else {
           LazyColumn() {
               items(uiState.products) { product ->
                   Text(text = product.title)
               }
           }
       }*/


}