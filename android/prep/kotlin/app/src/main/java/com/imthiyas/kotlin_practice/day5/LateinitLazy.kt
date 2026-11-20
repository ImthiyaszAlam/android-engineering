package com.imthiyas.kotlin_practice.day5

import android.util.Log


lateinit var userName: String
fun practiceLateLazy() {


    userName = "Imthiyas Alam"
    userName.run {
        Log.d("practiceLateLazy", userName)
    }

    val profileName by lazy {
        "Imthiyas-Lazy"
    }

    println(profileName)

    Log.d("practiceLateLazy", userName)

}