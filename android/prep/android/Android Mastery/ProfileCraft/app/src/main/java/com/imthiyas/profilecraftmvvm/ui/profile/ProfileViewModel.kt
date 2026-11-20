package com.imthiyas.profilecraftmvvm.ui.profile

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel() : ViewModel() {

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val phone = MutableLiveData<String>()


    val nameError = MediatorLiveData<String?>()
    val emailError = MediatorLiveData<String?>()
    val phoneError = MediatorLiveData<String?>()


    val isFormValid = MediatorLiveData<Boolean>()


    init {
        nameError.addSource(name) {
            nameError.value = if (it.isNullOrBlank()) "Name Required" else null
            validateForm()
        }

        emailError.addSource(email) {
            emailError.value =
                if (!it.isNullOrBlank() && !android.util.Patterns.EMAIL_ADDRESS.matcher(it)
                        .matches()
                ) "Invalid Email" else null

            validateForm()
        }

        phoneError.addSource(phone) {
            phoneError.value =
                if (it.isNullOrBlank()) "Phone Required" else if (it.length < 10 || it.length > 10) "Required 10 digit" else null
            validateForm()
        }
    }


    private fun validateForm() {
        isFormValid.value =
            nameError.value == null &&
                    emailError.value == null &&
                    phoneError.value == null &&
                    !name.value.isNullOrBlank() &&
                    !email.value.isNullOrBlank() &&
                    !phone.value.isNullOrBlank()
    }

     fun saveProfile() {
        Log.d("ProfileViewModel", "Saved ${name.value}, ${email.value} , ${phone.value}")
    }
}