package com.example.devexplorer.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devexplorer.data.repository.UserRepository
import com.example.devexplorer.ui.state.ProfileUiState
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val state: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadUserProfile("")
    }

    fun loadUserProfile(userName: String) {

        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            try {


                val defProfile = async {
                    userRepository.getUserProfile(userName)
                }

                val defRepos = async {
                    userRepository.getUserRepo(userName)
                }
                val profile = defProfile.await()
                val repos = defRepos.await()

                _uiState.update {
                    it.copy(
                        profile = profile,
                        repos = repos
                    )
                }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Something went wrong !"
                    )

                }
            }
        }
    }

}