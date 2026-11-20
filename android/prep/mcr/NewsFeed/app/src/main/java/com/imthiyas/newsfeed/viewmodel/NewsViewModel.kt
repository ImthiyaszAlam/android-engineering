package com.imthiyas.newsfeed.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.newsfeed.data.repository.NewsRepository
import com.imthiyas.newsfeed.ui.NewsUiState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    companion object {
        private const val PAGE_SIZE = 20
    }

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    private var generation = 0
    private var refreshJob: Job? = null
    private var pageJob: Job? = null


    init {
        refresh()
    }

    fun refresh() {
        val requestGeneration = ++generation
        pageJob?.cancel()
        pageJob = null
        refreshJob?.cancel()

        _uiState.update {
            it.copy(
                isRefreshing = true,
                isLoadingMore = false,
                error = null,
                refreshError = null,
                loadMoreError = null
            )
        }

        refreshJob = viewModelScope.launch {
            try {
                val posts = repository.getPosts(
                    1,
                    PAGE_SIZE
                )

                if (requestGeneration != generation) return@launch

                _uiState.value = NewsUiState(
                    posts = posts.distinctBy { it.id },
                    page = 1,
                    hasMore = posts.size == PAGE_SIZE
                )


            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                if (requestGeneration != generation) return@launch
                _uiState.update {
                    it.copy(
                        isRefreshing = false,
                        error = if (it.posts.isEmpty()) {
                            e.message ?: "Unable to load news"
                        } else {
                            null
                        },
                        refreshError = if (it.posts.isNotEmpty()) {
                            "Refresh failed. Showing existing posts."
                        } else {
                            null
                        }
                    )
                }
            }
        }
    }


    fun loadNextPage() {
        loadPage(false)
    }

    fun retryNextPage() {
        loadPage(true)
    }

    private fun loadPage(forceRetry: Boolean) {
        val current = _uiState.value
        if (current.isRefreshing || current.isLoadingMore || !current.hasMore) {
            return
        }

        if (current.loadMoreError != null && !forceRetry) {
            return
        }

        _uiState.update {
            it.copy(
                isLoadingMore = true,
                loadMoreError = null
            )
        }

        val requestGeneration = generation
        val requestedPage = current.page + 1

        pageJob = viewModelScope.launch {
            try {
                val newPosts = repository.getPosts(requestedPage, PAGE_SIZE)
                if (requestGeneration != generation) return@launch

                _uiState.update { latest ->
                    val mergedPost = (latest.posts + newPosts).distinctBy { it.id }
                    latest.copy(
                        posts = mergedPost,
                        page = requestedPage,
                        hasMore = newPosts.size == PAGE_SIZE,
                        isLoadingMore = false,
                        loadMoreError = null
                    )

                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                if (requestGeneration != generation) return@launch
                _uiState.update {
                    it.copy(
                        isLoadingMore = false,
                        loadMoreError = e.message
                            ?: "Unable to load more posts."
                    )
                }
            }
        }
    }

}