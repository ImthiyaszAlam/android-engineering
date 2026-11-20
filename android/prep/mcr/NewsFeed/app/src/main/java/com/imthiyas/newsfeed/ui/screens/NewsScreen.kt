package com.imthiyas.newsfeed.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.imthiyas.newsfeed.composables.NewsPostItem
import com.imthiyas.newsfeed.viewmodel.NewsViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import androidx.compose.material3.pulltorefresh.PullToRefreshBox


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    viewModel: NewsViewModel
) {

    val state by viewModel.uiState.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(
        listState,
        state.posts.size,
        state.hasMore,
        state.isLoadingMore,
        state.isRefreshing,
        state.loadMoreError
    ) {
        snapshotFlow {
            val layoutInfo = listState.layoutInfo
            val lastVisibleIndex =
                layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -1

            layoutInfo.totalItemsCount > 0 &&
                    lastVisibleIndex >= layoutInfo.totalItemsCount - 3
        }.distinctUntilChanged()
            .collect { nearBottom ->
                if (nearBottom) {
                    viewModel.loadNextPage()
                }
            }

    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Feed") },
                actions = {
                    Button(
                        onClick = viewModel::refresh,
                        enabled = !state.isRefreshing
                    ) {
                        Text(text = "Refresh")
                    }
                }

            )
        }
    )
    { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {


                state.posts.isEmpty() &&
                        state.isRefreshing -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                state.posts.isEmpty() &&
                        state.error != null -> {
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(state.error!!)

                        Spacer(Modifier.height(12.dp))

                        Button(onClick = viewModel::refresh) {
                            Text("Retry")
                        }
                    }
                }

                else -> {

                    LazyColumn(
                        state = listState,
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {


                        item {
                            state.refreshError?.let { message ->
                                Text(
                                    text = message,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }
                        }

                        items(
                            items = state.posts,
                            key = { post -> post.id }
                        ) { post ->
                            NewsPostItem(post)
                        }


                        item {
                            when {
                                state.isLoadingMore -> {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        CircularProgressIndicator()
                                    }
                                }

                                state.loadMoreError != null -> {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp),
                                        horizontalAlignment =
                                            Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = state.loadMoreError!!,
                                            color = MaterialTheme
                                                .colorScheme.error
                                        )

                                        Spacer(Modifier.height(8.dp))


                                        Button(
                                            onClick =
                                                viewModel::retryNextPage
                                        ) {
                                            Text("Retry loading more")
                                        }


                                    }
                                }


                                !state.hasMore && state.posts.isNotEmpty() -> {
                                    Text(
                                        text = "You're all caught up!",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    )
                                }
                            }
                        }


                    }
                }


            }

            PullToRefreshBox(
                isRefreshing = state.isRefreshing,
                onRefresh = viewModel::refresh,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

            }

        }


    }
}