package com.imthiyas.shopease.ui.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.imthiyas.shopease.data.remote.models.Category


@Composable
fun CategorySection(
    categories: List<Category>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {

    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            FilterChip(
                selected = selectedCategory == "all",
                onClick = { onCategorySelected },
                label = { Text("All") }

            )
        }

        items(categories) { category ->
            FilterChip(
                selected = selectedCategory == category.slug,
                onClick = { onCategorySelected(category.slug) },
                label = { Text(text = category.name) }

            )

        }


    }

}