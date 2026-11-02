package com.imthiyas.kotlin_practice.day1

import android.util.Log

fun practiceWhen() {

    val TAG = "practiceWhen"

    val day = 2

    when (day) {
        1 -> Log.d(TAG, "Monday")
        2 -> Log.d(TAG, "Tuesday")
        3 -> Log.d(TAG, "Wed")
        4 -> Log.d(TAG, "Thurdsday")
        else -> Log.d(TAG, "Invalid ")
    }

    val days = 6
  val result =   when (days) {
        1, 2, 3, 4, 5 -> "Monday-Friday"
        6, 7 -> "WEEKEND"
        else -> "Invalid Day"
    }
    Log.d(TAG, "$result")
}