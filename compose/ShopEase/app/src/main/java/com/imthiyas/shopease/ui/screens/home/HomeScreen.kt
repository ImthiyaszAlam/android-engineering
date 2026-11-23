package com.imthiyas.shopease.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.imthiyas.shopease.ui.screens.components.CategorySection
import com.imthiyas.shopease.ui.screens.components.DealBanner
import com.imthiyas.shopease.ui.screens.components.HomeHeader
import com.imthiyas.shopease.ui.screens.components.ProductGrid
import com.imthiyas.shopease.ui.screens.components.SearchBar
import com.imthiyas.shopease.ui.vm.CartViewModel
import com.imthiyas.shopease.ui.vm.FavoriteViewModel
import com.imthiyas.shopease.ui.vm.HomeViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    fvm: FavoriteViewModel = hiltViewModel(),
    cvm: CartViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val filteredProducts by viewModel.filteredProducts.collectAsStateWithLifecycle(emptyList())
    val favorites by fvm.favourites.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) { }

    Scaffold(
        topBar = {
            HomeHeader()
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }

    ) { paddingValues ->
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



            when {

                uiState.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }

                uiState.error != null -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(text = uiState.error!!)

                        Button(onClick = viewModel::retry) {
                            Text(text = "Retry")
                        }
                    }

                }

                filteredProducts.isEmpty() -> {
                    Text(
                        text = "No Products Found !",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }

                else -> {
                    ProductGrid(
                        products = filteredProducts,
                        favorites = favorites,
                        onFavoriteClick = fvm::toggleFavourite,
                        onAddToCart = { pId ->
                            cvm.addToCart(pId)
                            scope.launch {
                                snackbarHostState.showSnackbar("Added o cart!")
                            }

                        },
                        modifier = Modifier.weight(1f)
                    )

                }
            }

        }

    }


}