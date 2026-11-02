package com.imthiyas.kotlin_practice.day5.smartcast

import android.util.Log
import com.imthiyas.kotlin_practice.data.User

fun practiceDestructuring() {

    val user = User("Imthiyas Alam", "89786767", 25, "profileimageuri")

    val (name, mobile, age, profileImage) = user
    println(name)
    println(mobile)
    println(age)
    println(profileImage)

    val dataUser = User("Alam", "897876776", 878, "image2")
    val (name1, mobile1, age1, profileImage1) = dataUser

    val result = with(dataUser) {
        Log.d("KotlinPractice-Destructuring", "$dataUser")
        Log.d("KotlinPractice-Destructuring", "${dataUser.component1()}")
    }

    Log.d("KotlinPractice-Destructuring", "$result")


}