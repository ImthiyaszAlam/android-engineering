package com.imthiyas.to_dolist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.to_dolist.data.Todo
import com.imthiyas.to_dolist.repository.TodoRepository
import kotlinx.coroutines.launch

class TodoViewModel(private val todoRepository: TodoRepository) : ViewModel() {
    val allTodos: LiveData<List<Todo>> = todoRepository.allTodos

    fun insertVM(todo: Todo) = viewModelScope.launch {
        todoRepository.insertTodoRepo(todo)
    }

    fun updateVM(todo: Todo) = viewModelScope.launch {
        todoRepository.updateTodoRepo(todo)
    }

    fun deleteVM(todo: Todo) = viewModelScope.launch {
        todoRepository.deleteTodoRepo(todo)
    }
}