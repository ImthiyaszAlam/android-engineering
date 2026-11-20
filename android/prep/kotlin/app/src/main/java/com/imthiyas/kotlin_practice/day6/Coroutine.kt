package com.imthiyas.kotlin_practice.day6

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun practiceCoroutine() {

    /* Main → UI
     IO → Network / Database / File
     Default → CPU-intensive work*/


    suspend fun getUserName(): String {
        return "Imthiyas Alam"
    }


    CoroutineScope(Dispatchers.Main).launch {

        val result = withContext(Dispatchers.IO) {
            getUserName()
        }


        Log.d("CoroutinePractice", "$result")
    }




}