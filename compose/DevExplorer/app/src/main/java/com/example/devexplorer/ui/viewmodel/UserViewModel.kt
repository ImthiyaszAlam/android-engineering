package com.example.devexplorer.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devexplorer.data.repository.UserRepository
import com.example.devexplorer.ui.UserUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(UserUiState())
    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()


    fun searchUser(query: String) {
        viewModelScope.launch {

            _uiState.value = UserUiState(isLoading = true)

            try {

                val users = userRepository.searchUser(query)
                _uiState.value = UserUiState(users = users)
            } catch (e: Exception) {
                _uiState.value =
                    UserUiState(isLoading = false, error = e.message ?: "Something went wrong!")
            }


        }
    }

}