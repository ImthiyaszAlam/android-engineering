package com.imthiyas.kotlin_practice.day5.scopefunctions

import android.util.Log
import com.imthiyas.kotlin_practice.data.User

fun practiceLet() {

    val userName: String? = "Imthiyas"

    userName?.let {
        println("Name: $it")
        println("Length: ${it.length}")

        Log.d("KotlinPractice", "$it , ${it.length}")
    }

    val user = User(
        "Imthiyas",
        "8271665765",
        25,
        "kjehhdhehbehbfe"
    )

    val imageUri: String? = user.profileImage
    imageUri?.let {

    }

    user?.let {
        println("user: ${user.name}")
        Log.d("KotlinPractice", "${user.name}")
    }

}