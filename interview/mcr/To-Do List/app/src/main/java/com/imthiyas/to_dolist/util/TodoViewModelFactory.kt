package com.imthiyas.to_dolist.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.imthiyas.to_dolist.repository.TodoRepository
import com.imthiyas.to_dolist.viewmodel.TodoViewModel

class TodoViewModelFactory(private val todoRepository: TodoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodoViewModel(todoRepository) as T
    }
}