package com.imthiyas.to_dolist.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.imthiyas.to_dolist.R
import com.imthiyas.to_dolist.data.Todo
import com.imthiyas.to_dolist.data.TodoDatabase
import com.imthiyas.to_dolist.repository.TodoRepository
import com.imthiyas.to_dolist.util.TodoViewModelFactory
import com.imthiyas.to_dolist.viewmodel.TodoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var todoViewModel: TodoViewModel
    private lateinit var adapter: TodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database = TodoDatabase.getDatabase(this)
        val repository = TodoRepository(database.todoDao())
        val factory = TodoViewModelFactory(repository)
        todoViewModel = ViewModelProvider(this, factory)[TodoViewModel::class.java]

        adapter = TodoAdapter { todo ->
            todoViewModel.updateVM(todo)
        }


        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        todoViewModel.allTodos.observe(this) { todos ->
            adapter.submitList(todos)
        }



        findViewById<Button>(R.id.addButton).setOnClickListener {
            val title = findViewById<EditText>(R.id.editText).text.toString()
            if (title.isNotEmpty()) {
                todoViewModel.insertVM(Todo(title = title))
                findViewById<EditText>(R.id.editText).text.clear()
            }
        }

    }


}