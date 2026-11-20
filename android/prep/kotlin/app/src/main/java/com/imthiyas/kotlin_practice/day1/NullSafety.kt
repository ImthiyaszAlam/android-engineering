package com.imthiyas.kotlin_practice.day1

import android.util.Log

fun practiceNullSafety() {

    val TAG = "practiceNullSafety"

    val sName: String? = null
    Log.d(TAG, "$sName")


    val Name2: String? = "Imthiyas"
    Log.d(TAG, "$Name2")

    val compnayName: String? = "PVT"
    val displayName = compnayName ?: "Consumer"
    Log.d(TAG, "$displayName")


    val nammn: String? = null
    val dName = nammn ?: "Name here "
    Log.d(TAG, "$dName")


    val namee: String? = null
    val result = namee?.length ?: 0

    Log.d(TAG, "$result")

    val number: String? = "98988787"
    val res = number!!.length
    Log.d(TAG, "$res")

    val name: String? = "Imthiyas Alam"
    val result1 = name!!.length
    Log.d(TAG, "$result1")


    val abc: String? = null
    val leng = abc?.length ?: "98989"
    Log.d(TAG, "$leng")

}