package com.imthiyas.kotlin_practice.day2

import android.util.Log

fun practiceHOF() {

    val TAG = "practiceHOF"

    fun calculate(
        a: Int,
        b: Int,
        operation: (Int, Int) -> Int
    ): Int {
        return operation(a, b)
    }

    val add = calculate(2, 3, { x, y ->
        x + y
    })

    val sub = calculate(2, 4, { a, b ->
        a - b
    })

    val mul = calculate(5, 4, { c, v ->
        c * v
    })


    val result = calculate(5, 10, { a, b ->
        a + b
    })

    Log.d(TAG,"$add")
    Log.d(TAG,"$sub")
    Log.d(TAG,"$mul")

}