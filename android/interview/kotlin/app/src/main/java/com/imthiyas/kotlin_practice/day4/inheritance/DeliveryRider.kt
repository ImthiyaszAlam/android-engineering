package com.imthiyas.kotlin_practice.day4.inheritance

import android.util.Log
import com.imthiyas.kotlin_practice.day4.Rider

class DeliveryRider(
    name: String,
    deliveries: Int,
    deliveryAmount: Double,
    val vehicle: String
) : Rider(name, deliveries, deliveryAmount) {


    override fun showDetails() {
        super.showDetails()
    }

}