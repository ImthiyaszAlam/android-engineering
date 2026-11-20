package com.imthiyas.kotlin_practice.day3

import android.util.Log

fun practiceMapTC() {

    val TAG = "practiceMapTC"

    val numbers = listOf<Int>(1, 2, 3, 4, 5, 7, 8)
    val result = numbers.map { number ->
        number * 2
    }

    Log.d(TAG, "$numbers")
    Log.d(TAG, "Result: $result")

    val names = listOf<String>("Imthiyas", "John", "alam")
    val result1 = names.map {
        it.uppercase()
    }

    Log.d(TAG, "Caps: $result1")
}