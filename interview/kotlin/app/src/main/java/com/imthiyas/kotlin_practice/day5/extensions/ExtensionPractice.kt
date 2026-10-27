package com.imthiyas.kotlin_practice.day5.extensions

fun String.addWelcome(): String {
    return "Welcome $this"
}

fun String.calculateLength(): Int {
    return this.length
}


