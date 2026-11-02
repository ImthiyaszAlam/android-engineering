package com.imthiyas.kotlin_practice.day2

import android.util.Log

fun practiceLambdas() {

    val TAG = "practiceLambdas"

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun addd(a: Int, b: Int): Int = a + b
    val addd = { a: Int, b: Int ->
        a + b
    }
    val res1 = add(1, 2)
    val res2 = addd(1, 2)
    val res3 = addd

    Log.d(TAG, "$res1")
    Log.d(TAG, "$res2")
    Log.d(TAG, "$res3")

    val square = { a: Int, b: Int ->
        a * b
    }

    Log.d(TAG, "$square")

    val sayHello = {
        Log.d(TAG, "Hello There !")
    }
    val helo = sayHello
    Log.d(TAG, "$helo")

    val adddddddd: (Int, Int) -> Int = { a: Int, b: Int ->
        a + b
    }

    Log.d(TAG, "$adddddddd")

}