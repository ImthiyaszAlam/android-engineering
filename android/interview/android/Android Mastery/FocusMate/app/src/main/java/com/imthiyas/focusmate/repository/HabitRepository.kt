package com.imthiyas.focusmate.repository

import androidx.lifecycle.LiveData
import com.imthiyas.focusmate.data.local.HabitDao
import com.imthiyas.focusmate.data.local.HabitEntity
import kotlinx.coroutines.flow.Flow

class HabitRepository(private val dao: HabitDao) {
    val allHabits: Flow<List<HabitEntity>> = dao.getAllHabits()

    suspend fun insertHabit(habit: HabitEntity) {
        dao.insertHabit(habit)
    }
}