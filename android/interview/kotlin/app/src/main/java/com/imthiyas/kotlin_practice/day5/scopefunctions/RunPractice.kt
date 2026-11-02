package com.imthiyas.kotlin_practice.day5.scopefunctions

import android.util.Log
import com.imthiyas.kotlin_practice.data.User

fun practiceRun() {

    val users = mutableListOf<User>(

        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        ),

        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        )
        ,
        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        ),

        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        )
        ,
        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        ),

        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        ),

        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        )
        ,
        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        )
        ,
        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        )
        ,
        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        ),

        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        ),

        User(
            "Alam", mobile = "98979878",
            age = 56,
            profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
        )

    )



    val user = User().apply {
        name = "Alamcmnjcn"
        mobile = "98979878"
        age = 56
        profileImage = "lkofjrnfjnrjfnjrnfjrjrjofjrfkrjjorjorjmvjrjvjrjjvj"
    }

    user.also {
        users.add(it)
    }.apply {
        name.uppercase()
    }.run {
        "$name is this :age is $age"
    }.let {
        user.name
    }
    val result = user.run {
        name.uppercase()
    }.also {
        Log.d("KotlinPractice-Run", "${user}")
    }

    user.also {
        Log.d("KotlinPractice-Run", "${result}")
    }
}