package com.imthiyas.shopease

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.imthiyas.shopease.data.remote.api.ProductApi
import com.imthiyas.shopease.ui.theme.ShopEaseTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    private lateinit var productApi: ProductApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lifecycleScope.launch {
            try {
                val products = productApi.getProducts(20, 10, 0)
                Log.d("API_TEST", "Total: ${products.products}")
                Log.d("API_TEST", "skip${products.skip}")
                Log.d("API_TEST", "skip${products.total}")
            } catch (e: Exception) {

            }
        }


        enableEdgeToEdge()
        setContent {

            ShopEaseTheme {
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopEaseTheme {

    }
}