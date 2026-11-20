package com.imthiyas.kotlin_practice.day3

import android.util.Log
import com.imthiyas.kotlin_practice.data.User

fun practiceSorted() {

    val TAG = "practiceSorted"

    val users = listOf<Int>(20, 10, 30, 15, 5, 25)
    val result = users.sortedByDescending {
        it
    }

    Log.d(TAG, "$result")


    val riders = listOf<User>(
        User("Imthiyas ", "8787878787", 87, "profileimage1"),
        User("Alam", "8787878787", 100, "profileimage1"),
        User("Rahul", "8787878787", 18, "profileimage1"),
        User("", "8787878787", 67, "profileimage1"),
        User("Imthiyas Alam", "8787878787", 27, "profileimage1")
    )

    val result1 = riders.sortedByDescending {
        it.age
    }


    Log.d(TAG, "$result1")
}