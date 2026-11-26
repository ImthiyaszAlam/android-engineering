package com.example.devexplorer.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.devexplorer.data.remote.dto.GitHubProfileDto
import com.example.devexplorer.ui.viewmodel.UserProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(viewModel: UserProfileViewModel = hiltViewModel()) {

    val profile by viewModel.state.value.profile


    Scaffold(
        topBar = { TopAppBar({ Text(text = "Profile") }) }
    ) { padd ->

        Column(modifier = Modifier.padding(padd)) {
            AsyncImage(model = profile.avatarUrl, contentDescription = null)
            Text(text = profile.name.toString())
            Text(text = profile.bio.toString())
            Text(text = profile.followers.toString())
            Text(text = profile.following.toString())
            Text(text = profile.publicRepos.toString())

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn() {
                items()
            }
        }
    }
}