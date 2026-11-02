package com.imthiyas.kotlin_practice.day3

import android.util.Log

fun practiceFilter() {

    val TAG = "practiceFilter"

    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60)
    val result = numbers.filter { num ->
        num > 10
    }
    Log.d(TAG, "$result")

    val nums = listOf<Int>(1, 2, 3, 45, 6, 7, 8, 9, 1, 2, 13, 14, 15)
    val evenNums = nums.filter {
        it % 2 == 0
    }
    Log.d(TAG, "evenNums: $evenNums")

    val oddNums = nums.filter {
        it % 2 != 0
    }
    Log.d(TAG, "oddNums: $oddNums")

    val riders = listOf<String>("Alam","Rohit","Mohit")
    val rRiders = riders.filter {
        it.contains("A")
    }
    Log.d(TAG, "rRiders: $rRiders")

}