package com.imthiyas.shopease.ui.screens.home

import androidx.compose.ui.graphics.Path.Companion.combine
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.shopease.data.remote.models.Product
import com.imthiyas.shopease.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ProductRepository,
    val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState(
            searchQuery = savedStateHandle["searchQuery"] ?: "",
            selectedCategory = savedStateHandle["selectedCategory"] ?: "all"

        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val searchQuery = MutableStateFlow("")

    val filteredProducts = combine(
        uiState,
        searchQuery.debounce(300)

    ) { state, query ->
        state.copy(
            searchQuery = query
        )

    }.map { state ->
        state.products.filter { product ->
            val matchesCategory = state.selectedCategory == "all" ||
                    product.category == state.selectedCategory

            val matchesSearch =
                product.title.contains(
                    state.searchQuery,
                    ignoreCase = true
                )
            matchesCategory && matchesSearch

        }

    }

    init {
        loadHomeData()
    }

    fun loadHomeData() {
        /* loadProducts()
         loadCategory()*/

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }

            try {


                val products = repository.getProducts()
                val categories = repository.getCategories()

                _uiState.update {
                    it.copy(isLoading = false, products = products, categories = categories)
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Something went wrong!"
                    )
                }
            }

        }
    }

    fun retry() {
        loadHomeData()
    }

    fun onSearchQueryChange(query: String) {
        savedStateHandle["searchQuery"] = query

        _uiState.update {
            it.copy(
                searchQuery = query
            )
        }
        searchQuery.value = query
    }

    fun getFilteredProducts(): List<Product> {
        val state = _uiState.value

        return state.products.filter { product ->
            val matchesCategory = state.selectedCategory == "all" ||
                    product.category == state.selectedCategory

            val matchesSearch = product.title.contains(
                state.searchQuery,
                ignoreCase = true
            )

            matchesCategory && matchesSearch

        }
    }

    fun onCategorySelected(category: String) {
        savedStateHandle["selectedCategory"] = category
        _uiState.update {
            it.copy(
                selectedCategory = category
            )
        }

    }

    fun loadProducts() {
        viewModelScope.launch() {

            _uiState.update {
                it.copy(isLoading = true)
            }
            try {
                val products = repository.getProducts()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        products = products
                    )
                }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Something went wrong!"
                    )
                }
            }
        }
    }

    fun loadCategory() {

        viewModelScope.launch {


            _uiState.update {
                it.copy(isLoading = true)
            }

            try {

                val categories = repository.getCategories()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        categories = categories
                    )
                }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Something went wrong"
                    )
                }

            }


        }

    }


}