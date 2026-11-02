package com.imthiyas.kotlin_practice.day3

import android.util.Log

fun practiceForEach() {

    val TAG = "practiceForEach"
    val riders = mutableMapOf(
        1 to "Alam",
        2 to "Imthiyas",
        3 to "Amit",
        4 to "Rahul"
    )

    for (rider in riders) {
        println(rider)
        Log.d(TAG, "$rider")
    }

    riders.forEach { i, name ->

        Log.d(TAG, "$i Name: $name")
    }

    val lRiders = listOf<String>(
        "Alam",
        "Rohit",
        "Amit"
    )
    lRiders.forEach { rider ->

        Log.d(TAG, " Name: $rider")
    }
}