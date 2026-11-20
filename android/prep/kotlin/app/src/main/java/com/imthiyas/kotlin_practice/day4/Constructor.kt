package com.imthiyas.kotlin_practice.day4

import android.util.Log

class Constructor(
    val name: String = "Alam",
    val deliveries: Int = 100,
    val amount: Double = 350.0
) {

    val TAG = "PracticeConstructor"

    init {
        showDetails()
    }

    fun showDetails() {
        Log.d(TAG, "Name : $name")
        Log.d(TAG, "Deliveries : $deliveries")
        Log.d(TAG, "Amount : $amount")
    }
}