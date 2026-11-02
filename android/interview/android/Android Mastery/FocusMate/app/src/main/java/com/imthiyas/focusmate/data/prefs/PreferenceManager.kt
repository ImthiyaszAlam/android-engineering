package com.imthiyas.focusmate.data.prefs

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//DataStore creation
val Context.dataStore by preferencesDataStore(name = "user_prefs")

class PreferenceManager(private val context: Context) {


    companion object {
        //Key to store onboarding values
        private val ONBOARDING_KEY = booleanPreferencesKey("onboarding_complete")
    }


    //Read status
    val onboardingFlow: Flow<Boolean> = context.dataStore.data.map { preference ->
        preference[ONBOARDING_KEY] ?: false

    }


    //Save status
    suspend fun setOnBoardingComplete(completed: Boolean) {
        context.dataStore.edit { preference ->
            preference[ONBOARDING_KEY] = completed
        }
    }

}