package com.example.testproject.ui.screen

import android.widget.Space
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.testproject.data.api.ApiService
import com.example.testproject.data.repository.ProductRepository
import com.example.testproject.ui.components.CategoryItem
import com.example.testproject.ui.components.ProductItem
import com.example.testproject.ui.theme.TestProjectTheme
import com.example.testproject.ui.uistate.ProductUiState
import com.example.testproject.ui.viewmodel.ProductViewModel
import com.example.testproject.ui.viewmodel.ProductViewModelProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {


    val repository: ProductRepository = ProductRepository(ApiService)
    val factory = ProductViewModelProvider(repository)
    val viewModel: ProductViewModel = ViewModel(factory = factory)

    val state = viewModel.uiState.collectAsStateWithLifecycle()


    Scaffold(


        topBar = {
            TopAppBar(

                {
                    Row() {
                        Text(text = "M")
                        Spacer(modifier = Modifier.width(16.dp))
                        Column() {
                            Text(text = "Good Morning")
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Hello Imthiyas")
                        }
                    }
                }

            )
        })


    { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        )

        {

            when (state) {

                ProductUiState.Loading -> {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }


                ProductUiState.Success -> {
                    LazyVerticalGrid(

                    ) {
                        items(
                            items = state.value
                        )

                        product ->

                        ProductItem(product = state.value)

                    }
                }
            }


            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(50.dp),
                value = "",
                onValueChange = "",
                state = "",
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box() {
                AsyncImage(
                    model = null,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    contentDescription = "Banner Image"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Categories")

            val categories = listOf("SmartPhone", "Laptop", "Groceries")
            /*
                        LazyRow() {
                            items(
                                items =categories.size,
                                key = {it.id}
                            )
                        }*/

            CategoryItem("SmartPhone")

            Spacer(modifier = Modifier.height(16.dp))


            LazyVerticalGrid(

            ) {
                items()
            }


        }


    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    TestProjectTheme {
        HomeScreen()
    }
}