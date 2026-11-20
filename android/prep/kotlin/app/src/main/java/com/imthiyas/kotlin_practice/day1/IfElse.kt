package com.imthiyas.kotlin_practice.day1

import android.util.Log

fun practiceIfElse() {

    val TAG = "practiceIfElse"

    val age = 25

    if (age > 18) {
        Log.d(TAG, "Adult: $age")
    } else {
        Log.d(TAG, "Minor: $age")
    }


    val result = if (age >= 18) {
        "Adult"
    } else {
        "Minot"
    }


    Log.d(TAG, "Minor: $result")

    val isOnline = true

    val isActive = if (isOnline) {
        "Online"
    } else {
        "Offline"
    }

    Log.d(TAG, "Minor: $isActive")

}