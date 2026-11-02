package com.imthiyas.kotlin_practice.day3

import android.util.Log

fun practiceCollections() {
    val TAG = "practiceCollections"

    val names = listOf("Imthiyas", "Alam", "Mehru", "Dilshad")
    names?.let {
        Log.d(TAG, "AlL Names: $names")
        Log.d(TAG, "${names[0]}")
        Log.d(TAG, "${names[1]}")
        Log.d(TAG, "${names[2]}")
    }
    val size = names.size
    Log.d(TAG, "Size:   ${size}")

    val mNames = mutableListOf<String>("Imthiyas", "Alam")

    Log.d(TAG, "Before Modification Names: $mNames")
    mNames.add("Android")
    mNames.add("Development")

    Log.d(TAG, "After Modification Names: $mNames")
    mNames.remove(mNames[3])

    Log.d(TAG, "After Removal Names: $mNames")

    for (name in mNames) {
        Log.d(TAG, "Names: $name")
    }


}