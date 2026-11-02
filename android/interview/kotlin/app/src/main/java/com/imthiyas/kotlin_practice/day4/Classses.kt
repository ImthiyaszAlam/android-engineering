package com.imthiyas.kotlin_practice.day4

import android.util.Log

class Classses {

    val TAG = "poracticeClasses"
    var name: String? = "Rahul"
    var deliveries = 120
    var amount = 350

    fun showDetails() {
        Log.d(TAG, "Name: $name")
        Log.d(TAG, "Deliveries: $deliveries")
        Log.d(TAG, "Amount: $amount")
    }
}