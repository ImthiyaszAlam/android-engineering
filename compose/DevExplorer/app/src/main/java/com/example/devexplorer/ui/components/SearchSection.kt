package com.example.devexplorer.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.devexplorer.ui.state.UserUiState
import com.example.devexplorer.ui.viewmodel.UserViewModel

@Composable
fun SearchSection(value: UserUiState, viewModel: UserViewModel, modifier: Modifier) {
    OutlinedTextField(
        value = value.query,
        onValueChange = viewModel::searchUser,
        modifier = modifier
            .fillMaxWidth()
            .border(border = BorderStroke(1.dp, Color.Transparent), shape = RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(16.dp),

        label = { Text(text = "Search User") },
        singleLine = true

    )
}