package com.example.composeplayground.ui.components

import android.content.Context
import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldScreen(context: Context) {

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val title = "Scaffold Structure"
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(title) })
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }, // 2. Attach host


        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Welcome to Compose Playground!")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    Toast.makeText(context, "Button clicked!", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Click Me")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    // 3. Launch Snackbar
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Button clicked!")
                    }
                }) {
                    Text("Second Click")
                }
            }
        }
    )
}