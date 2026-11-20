package com.imthiyas.kotlin_practice.day5.scopefunctions

import android.util.Log
import com.imthiyas.kotlin_practice.data.User

fun practiceWith() {

    val user = User().apply {
        name = "Imthiyas"
        mobile = "87897897"
        age = 87
        profileImage = "9890890898d,cnjhhegyfy7y78e4urfnfneiuf"
    }

 val result =    with(user) {
        "$name is $age year old his image is $profileImage and mobile is : $mobile"
    }

    user.run {
        "$name is $age year old his image is $profileImage and mobile is : $mobile"
    }.also {
        Log.d("KotlinPractice-With", "${result}")
    }

}