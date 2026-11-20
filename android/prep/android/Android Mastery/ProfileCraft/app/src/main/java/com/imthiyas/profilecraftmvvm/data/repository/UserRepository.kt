package com.imthiyas.profilecraftmvvm.data.repository

import android.util.Log
import com.imthiyas.profilecraftmvvm.data.model.User

class UserRepository {

    fun getUser(): User {
        return User("Alam", "alam@gmail.com", "1234567890")
    }

    fun saveUser(user: User) {
        Log.d("user", "$user")
    }
}