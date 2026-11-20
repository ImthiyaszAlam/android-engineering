package com.imthiyas.focusmate.data.repository

import androidx.lifecycle.map
import com.imthiyas.focusmate.data.local.HabitDao
import com.imthiyas.focusmate.data.local.toEntity
import com.imthiyas.focusmate.data.local.toHabit
import com.imthiyas.focusmate.domain.model.Habit
import com.imthiyas.focusmate.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HabitRepositoryImpl(private val dao: HabitDao) : HabitRepository {

    override fun getAllHabits(): Flow<List<Habit>> {
        return dao.getAllHabits().map { entities ->
            entities.map { it.toHabit() }

        }
    }

    override suspend fun addHabit(habit: Habit) {
        return dao.insertHabit(habit.toEntity())
    }

}