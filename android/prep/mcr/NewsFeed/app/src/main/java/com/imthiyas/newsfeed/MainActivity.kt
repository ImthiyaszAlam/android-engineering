package com.imthiyas.newsfeed

import android.os.Bundle
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imthiyas.newsfeed.data.api.RetrofitClient
import com.imthiyas.newsfeed.data.repository.NewsRepositoryImpl
import com.imthiyas.newsfeed.ui.screens.NewsScreen
import com.imthiyas.newsfeed.ui.theme.NewsFeedTheme
import com.imthiyas.newsfeed.viewmodel.NewsViewModel
import com.imthiyas.newsfeed.viewmodel.NewsViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val repository = NewsRepositoryImpl(
            api = RetrofitClient.newsApi
        )

        val factory = NewsViewModelFactory(repository)




        setContent {
            NewsFeedTheme {
                val newsViewModel: NewsViewModel = viewModel(
                    factory = factory
                )

                NewsScreen(viewModel = newsViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsFeedTheme {
        Greeting("Android")
    }
}