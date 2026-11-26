package com.example.devexplorer.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.devexplorer.data.remote.dto.GitHubUserDto
import com.example.devexplorer.ui.components.SearchSection
import com.example.devexplorer.ui.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Home") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        )
        {

            SearchSection(uiState, viewModel, modifier = Modifier.padding(vertical = 16.dp))

            when {
                uiState.isLoading -> {

                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }

                uiState.error != null -> {
                    Text(text = uiState.error.toString())
                    Log.d("API_ERROR", uiState.error.toString())
                }

                uiState.users.isEmpty() -> {

                    Text(text = "User not found!")
                }

                else -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        items(uiState.users) { user ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AsyncImage(
                                    model = user.avatarUrl,
                                    contentDescription = user.login,
                                    modifier = Modifier
                                        .size(52.dp)
                                        .clip(shape = RoundedCornerShape((50.dp)))
                                )

                                Spacer(modifier = Modifier.width(12.dp))

                                Text(
                                    text = user.login,
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                        }
                    }
                }
            }


        }

    }
}


