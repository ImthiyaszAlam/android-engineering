package com.imthiyas.kotlin_practice.day5.smartcast

import kotlin.math.sign

fun practiceCasting() {

    val name: Any = "Imthiyas Alam"
    val role: Any = "Android Engineer"

    if (name is String) {
        println(name)
    }

    if (role is String) {
        println(role)
    }

    val number:Any =100
    if (number is Int){
        println(number)
    }

    (number as Int)

    (role as String).length
    (name as String).length

    val numResult = number as? Int
    println(numResult)









}