package com.imthiyas.shopease.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.shopease.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    val total = 20
    val skip = 0;
    val limit = 10

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
        _uiState.update {
            it.copy(
                searchQuery = query
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