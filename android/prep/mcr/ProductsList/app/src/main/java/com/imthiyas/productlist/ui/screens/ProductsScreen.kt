package com.imthiyas.productlist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imthiyas.productlist.data.api.RetrofitClient
import com.imthiyas.productlist.data.repository.ProductRepository
import com.imthiyas.productlist.ui.components.ProductItem
import com.imthiyas.productlist.ui.uistate.ProductUiState
import com.imthiyas.productlist.ui.viewmodel.ProductViewModel
import com.imthiyas.productlist.ui.viewmodel.ProductViewModelFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen() {


    val respository = remember {
        ProductRepository(RetrofitClient.apiService)
    }

    val factory = remember {
        ProductViewModelFactory(repository = respository)
    }

    val viewModel: ProductViewModel = viewModel(factory = factory)

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()



    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    "Products",
                    style = MaterialTheme.typography.bodyMedium
                )
            })
        }
    )

    { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        )
        {

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                when (val state = uiState) {


                    is ProductUiState.Loading -> {
                        Box(contentAlignment = Alignment.Center) {
                            CircularProgressIndicator()
                        }
                    }


                    is ProductUiState.Success->{
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier.fillMaxWidth(),

                        ) {



                            items(
                                items = state.products,
                                key = { it.id }
                            ) { product ->
                                ProductItem(product)
                            }
                        }
                    }

                    is ProductUiState.Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(state.message)
                        }
                    }
                }


            }

        }
    }
}