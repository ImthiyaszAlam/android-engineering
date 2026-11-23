package com.imthiyas.shopease.ui.vm

import androidx.lifecycle.ViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FavoriteViewModel @Inject constructor(
) : ViewModel() {


    private val _favourites = MutableStateFlow<Set<Int>>(emptySet())
    val favourites = _favourites.asStateFlow()


    fun toggleFavourite(productId: Int) {
        _favourites.update { current ->
            if (productId in current) {
                current - productId
            } else {
                current + productId
            }
        }
    }

}