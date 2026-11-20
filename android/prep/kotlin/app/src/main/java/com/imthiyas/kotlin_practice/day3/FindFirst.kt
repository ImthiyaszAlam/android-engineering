package com.imthiyas.kotlin_practice.day3

import android.util.Log

fun practiceFindFirst() {
    val TAG = "practiceFindFirst"

    val nums = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val find = nums.find {
        it > 5
    }

    Log.d(TAG, "$find")

    val first = nums.first()
    Log.d(TAG, "$first")

    val firstNull = nums.firstOrNull { it < 7 }
    Log.d(TAG, "$firstNull")


}