package com.imthiyas.kotlin_practice.day1

import android.util.Log

fun practiceVariables() {

    val TAG = "practiceVariables"

    val name = "Imthiyas"
    val age = 25

    val numbers = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
    numbers.add(7)
    numbers.remove(numbers[4])

    Log.d(TAG, "$numbers")

    var number = 40
    Log.d(TAG, "${number + 2} ")
    number = 50
    Log.d(TAG, "$number")
    number = 60
    Log.d(TAG, "$number")


    val name1: String = "Imthiyas"
    val salary: Double = 878787.989
    val isActive: Boolean = true


    Log.d(TAG, "$name1 make $salary and isActive $isActive")
    val a = 20
    val b = 30


    Log.d(TAG, "Adition: ${a + b}")
    Log.d(TAG, "Subtraction: ${a - b}")
    Log.d(TAG, "Multiplication: ${a * b}")
    Log.d(TAG, "Division: ${a % b}")


}