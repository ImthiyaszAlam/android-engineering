package com.imthiyas.kotlin_practice.day5.scopefunctions

import android.content.Intent
import android.util.Log
import com.imthiyas.kotlin_practice.data.User

fun practiceApply() {


    val user = User(
    ).apply {
        name = "Imthiyas"
        mobile = "9889798787"
        age = 25
        profileImage = "khdhee"
    }
    println(user)
    user?.let {
        Log.d("KotlinPractice", "User: ${user}")
    }


}