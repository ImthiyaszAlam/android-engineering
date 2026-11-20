package com.imthiyas.kotlin_practice.day6

import android.util.Log
import com.imthiyas.kotlin_practice.data.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

fun practiceFlow() {


    val numbers = flow {
        emit(1)
        delay(1000)
        emit(2)
        delay(1000)
        emit(3)
        delay(1000)
        emit(4)
        delay(1000)
        emit(5)
        delay(1000)
        emit(6)
    }

    CoroutineScope(Dispatchers.IO).launch {
        numbers.filter { it % 2 == 0 }
            .map { it * 10 }
            .collect {
                Log.d("PracticeFlow", it.toString())
            }
    }

    val users = flow {
        emit(User("Imthiyas", "89776", 26, "image"))
        delay(1000)
        emit(User("Alam", "89776", 26, "image"))
        delay(1000)
        emit(User("Imthiyas", "89776", 26, "image"))
        delay(1000)
        emit(User("Alam", "89776", 26, "image"))
        delay(1000)
        emit(User("Imthiyas", "89776", 26, "image"))
    }

    CoroutineScope(Dispatchers.IO).launch {
        users
            .collect { user ->
                Log.d("PracticeFlow", "$user")
            }
    }

    val _state = MutableStateFlow("Loading")
    val state: StateFlow<String> = _state

    CoroutineScope(Dispatchers.IO).launch {
        _state.collect {
            Log.d("StateFlow", it)
        }
    }
    _state.value = "Success"

}