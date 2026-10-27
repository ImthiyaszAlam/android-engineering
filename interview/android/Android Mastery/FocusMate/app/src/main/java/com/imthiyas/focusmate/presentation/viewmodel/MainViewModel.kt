package com.imthiyas.focusmate.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.focusmate.domain.model.Habit
import android.util.Log
import com.imthiyas.focusmate.domain.repository.HabitRepository
import com.imthiyas.focusmate.domain.usecase.HabitUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val habitRepository: HabitRepository) :
    ViewModel() {


    val habits = habitRepository.getAllHabits()


    fun addHabit(habit: Habit) {
        viewModelScope.launch {
            habitRepository.addHabit(habit)
        }
    }
}