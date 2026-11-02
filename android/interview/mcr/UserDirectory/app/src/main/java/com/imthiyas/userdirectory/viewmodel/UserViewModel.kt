package com.imthiyas.userdirectory.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.userdirectory.data.UserRepository
import com.imthiyas.userdirectory.model.SortOrder
import com.imthiyas.userdirectory.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

class UserViewModel(val repository: UserRepository) : ViewModel() {

    private var users: List<User> = repository.getUsers()


    private val _searchQuery = MutableStateFlow("")
    val searchedQuery = _searchQuery.asStateFlow()
    private val _filteredUsers = MutableStateFlow(users)
    val filteredUsers = _filteredUsers.asStateFlow()

    private val _sortOrder = MutableStateFlow(SortOrder.NONE)
    val sortOrder = _sortOrder.asStateFlow()


    init {
        viewModelScope.launch {

            combine(          _searchQuery.debounce(300),
                _sortOrder){
                    query, sortOrder ->
                query to sortOrder
            }

                .collectLatest {( query,sortOrder) ->
                  val filtered  = users.filter {
                        it.name.contains(query, ignoreCase = true) ||
                                it.role.contains(query, ignoreCase = true) ||
                                it.id.toString().contains(query)
                    }

                    val sorted = when (sortOrder) {
                        SortOrder.NONE -> filtered
                        SortOrder.LOW_TO_HIGH -> filtered.sortedBy { it.salary }
                        SortOrder.HIGH_TO_LOW -> filtered.sortedByDescending { it.salary }
                    }

                    _filteredUsers.value = sorted

                }
        }
    }

    fun onSearchQueryChange(query: String) {

        _searchQuery.value = query

    }

    fun sortOrderValue(value: SortOrder) {
        _sortOrder.value = value
    }


}