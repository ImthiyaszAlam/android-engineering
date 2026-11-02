package com.imthiyas.kotlin_practice.day3

import android.util.Log

fun practiceMap() {

    val TAG = "practiceMap"

    val riders = mapOf(
        1 to "Imthiyas",
        2 to "Rahul",
        3 to "Amit",
        4 to "Alam"
    )

    Log.d(TAG, "$riders")


    for ((id, name) in riders) {
        Log.d(TAG, "$name & $id")
    }

    val mRiders = mutableMapOf(
        1 to "Rider 1",
        2 to "Rider 2"
    )
    Log.d(TAG, "$mRiders")

    mRiders[2] = "Alamm"
    mRiders.remove(3)

    Log.d(TAG, "$mRiders")
}