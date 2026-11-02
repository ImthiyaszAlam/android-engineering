package com.imthiyas.userdirectory.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material.icons.outlined.PersonSearch
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.imthiyas.userdirectory.model.SortOrder
import com.imthiyas.userdirectory.viewmodel.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(
    userViewModel: UserViewModel
) {


    val query by userViewModel.searchedQuery.collectAsStateWithLifecycle()
    val users by userViewModel.filteredUsers.collectAsStateWithLifecycle()
    var expanded by remember { mutableStateOf(false) }
    val sortOrder by userViewModel.sortOrder.collectAsStateWithLifecycle()

    val listState = rememberLazyListState()

    LaunchedEffect(query, sortOrder) {
        listState.scrollToItem(0)
    }


    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "User Directory",
                    style = MaterialTheme.typography.headlineSmall
                )
            })
        }
    )
    { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                OutlinedTextField(

                    value = query,
                    shape = RoundedCornerShape(100.dp),
                    onValueChange = userViewModel::onSearchQueryChange,
                    modifier = Modifier.weight(1f),
                    label = {
                        Text(text = "Search User")
                    },
                    placeholder = {
                        Text(text = "Search by name,role and id")
                    },
                    singleLine = true

                )


                Box() {
                    IconButton(onClick = { expanded = true }) {
                        Icon(imageVector = Icons.Default.Sort, contentDescription = null)
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {

                        DropdownMenuItem(
                            text = { Text("None") },
                            onClick = {
                                userViewModel.sortOrderValue(SortOrder.NONE)
                                expanded = false
                            }
                        )


                        DropdownMenuItem(
                            text = { Text("Salary: Low to High") },
                            onClick = {
                                userViewModel.sortOrderValue(SortOrder.LOW_TO_HIGH)
                                expanded = false
                            }
                        )

                        DropdownMenuItem(
                            text = { Text("Salary: High to Low") },
                            onClick = {
                                userViewModel.sortOrderValue(SortOrder.HIGH_TO_LOW)
                                expanded = false
                            }
                        )

                    }
                }


            }



            if (users.isEmpty()) {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.PersonSearch,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "No users found",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(
                            text = "Try a different name, role, or ID.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                }

            } else {
                LazyColumn(
                    state = listState,
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = users,
                        key = { user -> user.id }
                    )
                    { user ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 12.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = user.name,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = user.role,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = "Salary: ₹${user.salary}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }

    }

}