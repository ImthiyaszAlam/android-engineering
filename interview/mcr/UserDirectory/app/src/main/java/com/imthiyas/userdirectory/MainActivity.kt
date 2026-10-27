package com.imthiyas.userdirectory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.imthiyas.userdirectory.data.UserRepository
import com.imthiyas.userdirectory.ui.screens.UserListScreen
import com.imthiyas.userdirectory.ui.theme.UserDirectoryTheme
import com.imthiyas.userdirectory.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {


    private val viewModel: UserViewModel by lazy {
        ViewModelProvider(
            this,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                        return UserViewModel(UserRepository()) as T
                    }
                    throw IllegalArgumentException("Unknown VM Class")
                }
            }
        )[UserViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserDirectoryTheme {
                UserListScreen(userViewModel = viewModel)
            }
        }
    }
}
