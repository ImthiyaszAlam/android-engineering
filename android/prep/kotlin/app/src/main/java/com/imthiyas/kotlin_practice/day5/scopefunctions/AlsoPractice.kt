package com.imthiyas.kotlin_practice.day5.scopefunctions

import android.util.Log
import com.imthiyas.kotlin_practice.data.User

fun practiceAlso() {

    val user = User().apply {
        name = "Imthiyas Alam"
        mobile = "9889898889"
        age = 36
        profileImage = "also image"
    }.also {
        Log.d("KotlinPractice", " New User created Also :  ${it}")
    }

    val userList = mutableListOf<String>()
    val newUser = mutableListOf<String>()
    newUser.apply {
        add("Alam")
        add("Imthiyas")
        add("Android")
    }.also {
        userList.add(it.toString())
    }.also {
        Log.d("KotlinPractice", " New User created Also :  ${userList}")
    }


}