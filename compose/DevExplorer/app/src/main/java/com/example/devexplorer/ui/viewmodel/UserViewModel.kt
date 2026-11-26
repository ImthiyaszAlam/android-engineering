package com.example.devexplorer.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devexplorer.data.repository.UserRepository
import com.example.devexplorer.ui.state.UserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(UserUiState())
    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()
    private var searchJob: Job? = null


    init {
        searchUser()
    }

    fun searchUser(query: String = "all") {
        searchJob?.cancel()

        searchJob = viewModelScope.launch {

            _uiState.value = UserUiState(isLoading = true)
            _uiState.update {
                it.copy(query = query)
            }
            delay(400)

            if (query.isBlank()) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        users = emptyList(),
                        error = null
                    )
                }
            }

            try {

                val users = userRepository.searchUser(query)
                _uiState.value = UserUiState(users = users.items)
            } catch (e: Exception) {
                _uiState.value =
                    UserUiState(isLoading = false, error = e.message ?: "Something went wrong!")
            }


        }
    }

}