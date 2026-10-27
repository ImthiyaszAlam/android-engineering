package com.imthiyas.kotlin_practice.day6

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun practiceSuspend() {


    suspend fun getUserName(): String {
        return "Imthiyas Alam"
    }

    CoroutineScope(Dispatchers.IO).launch {
        val result = getUserName()
        result.run {
            Log.d("CoroutinePractice", "$result")
        }
    }

}