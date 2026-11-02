package com.imthiyas.kotlin_practice.day2

import android.util.Log
import androidx.compose.runtime.Composable

fun practiceFunctions() {

    val TAG = "practiceFunctions"

    fun sayHello() {
        Log.d(TAG, "Hello Imthiyas")
    }

    fun sayHelloParam(name: String) {
        Log.d(TAG, "Hello $name")
    }

    fun addNumbers(a: Int, b: Int): Int {
        return a + b

    }

    val result = addNumbers(3, 4)

    Log.d(TAG, "Hello $result")

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    val result0 = multiply(3, 4)
    Log.d(TAG, "Hello $result0")


    fun greet(name: String = "Imthiyas"): String {
        return "Hello $name"
    }

    val greet = greet()
    Log.d(TAG, "$greet")



    fun addNumbs(vararg num: Int): Int {
        var total = 0;
        for (n in num) {
            total += n
        }
        return total
    }

    val res = addNumbs(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    Log.d(TAG, "Numbers: $res")


    fun addd(a: Int, b: Int): Int = a + b
    fun subtract(a: Int, b: Int): Int = a - b
    fun isAdult(age: Int) = age >= 18
    fun isEligible(age: Int) = age >= 10
    fun welcome(msg: String) = "Welcome $msg"

}