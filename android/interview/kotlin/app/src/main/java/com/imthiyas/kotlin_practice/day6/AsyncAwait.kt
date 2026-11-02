package com.imthiyas.kotlin_practice.day6

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun practiceAsyncAwait() {

    suspend fun getUserName(): String {
        return "Imthiyas Alam"
    }


    suspend fun getUserAge(): Int {
        return 25
    }

    suspend fun getUserMobile(): String {
        return "989789787878"
    }

    /*Independent Concurrent Operations using async and await */

    CoroutineScope(Dispatchers.Main).launch {


        val result = withContext(Dispatchers.IO) {


            val deferredName = async { getUserName() }
            val deferredAge = async { getUserAge() }
            val deferredMobile = async { getUserMobile() }

            Log.d("CoroutinePractice", " Deferred: $deferredName , $deferredAge , $deferredMobile")

            val name = deferredName.await()
            val age = deferredAge.await()
            val mobile = deferredMobile.await()



            Log.d("CoroutinePractice", "Result : $name , $age , $mobile")

            val allResult = awaitAll(deferredName, deferredAge, deferredMobile)

            Log.d("CoroutinePractice", "allResult- : $allResult")

        }


        Log.d("CoroutinePractice", "Result- : $result")

    }

    /*Dependent Sequential Operations */

    CoroutineScope(Dispatchers.IO).launch {
        val userName = getUserName()
        val age = getUserAge()
        val mobile = getUserMobile()



        Log.d("CoroutinePractice", "Dependent Sequential Operations : $userName , $age , $mobile")

    }


    //Job
    CoroutineScope(Dispatchers.IO).launch {


        launch {
            Log.d("Coroutine", "Child 1")
        }

        launch {
            Log.d("Coroutine", "Child 2")
        }
    }

    //Job Cancellation

    val job = CoroutineScope(Dispatchers.IO).launch {
        repeat(10) {
            delay(1000)


            if (isActive) {
                Log.d("Coroutine", "Running: $it")
            } else {
                Log.d("Coroutine", "Cancelled: $it")
            }
        }
    }
    job.cancel()


    val result1 = CoroutineScope(Dispatchers.IO).launch {
        launch {
            repeat(10) {
                Log.d("Coroutine", "A before")
                delay(5000)
                Log.d("Coroutine", "A after")
            }
        }

        launch {
            repeat(20) {
                Log.d("Coroutine", "B before")
                delay(1000)
                Log.d("Coroutine", "B after")
            }
        }
    }

    Log.d("Coroutine", "result1 $result1")

    CoroutineScope(Dispatchers.IO).launch {
        try {
            val result = getUserName()

        } catch (e: Exception) {
            Log.d("", "${e.message as? String}")
        }
    }



}