package com.imthiyas.kotlin_practice.day4

import android.util.Log

open class Rider(
    val name: String,
    val deliveries: Int,
    val deliveryAmount: Double
) {

    open val TAG = "PracticeInheritance"
  open  fun showDetails() {
        Log.d(TAG, "Name: $name")
        Log.d(TAG, "deliveries: $deliveries")
        Log.d(TAG, "deliveryAmount: $deliveryAmount")
    }

}
