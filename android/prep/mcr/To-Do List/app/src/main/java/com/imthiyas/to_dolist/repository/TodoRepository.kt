package com.imthiyas.to_dolist.repository

import androidx.lifecycle.LiveData
import com.imthiyas.to_dolist.data.Todo
import com.imthiyas.to_dolist.data.TodoDao

class TodoRepository(private val todoDao: TodoDao) {
    /*LiveData automatic UI update whenever todo chnages */
    val allTodos: LiveData<List<Todo>> = todoDao.getAllTodos()

    suspend fun insertTodoRepo(todo: Todo) = todoDao.insertTodo(todo)
    suspend fun updateTodoRepo(todo: Todo) = todoDao.updateTodo(todo)
    suspend fun deleteTodoRepo(todo: Todo) = todoDao.deleteTodo(todo)

}