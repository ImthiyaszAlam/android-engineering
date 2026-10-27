package com.imthiyas.kotlin_practice.day3

import android.util.Log

fun practiceSet() {

    val TAG = "practiceSet"
    val riders = setOf<String>("Imthiyas", "Alam")
    for (rider in riders) {
        Log.d(TAG, "$rider")
    }

    val riderList = mutableSetOf<String>("Alam", "Imthiyas", "Alam", "Android")
    riderList.add("Engineer")
    riderList.add("Development")
    Log.d(TAG, "$riderList")

    for (rider in riderList) {
        Log.d(TAG, "$rider")
    }

    riderList.remove("Alam")

    Log.d(TAG, "$riderList")

}