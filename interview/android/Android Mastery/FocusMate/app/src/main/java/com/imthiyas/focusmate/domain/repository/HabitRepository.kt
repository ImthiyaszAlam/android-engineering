package com.imthiyas.focusmate.domain.repository

import com.imthiyas.focusmate.domain.model.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {

    fun getAllHabits(): Flow<List<Habit>>
    suspend fun addHabit(habit: Habit)
}