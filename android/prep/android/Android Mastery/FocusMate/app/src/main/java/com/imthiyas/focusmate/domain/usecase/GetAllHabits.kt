package com.imthiyas.focusmate.domain.usecase

import com.imthiyas.focusmate.domain.model.Habit
import com.imthiyas.focusmate.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow

class GetAllHabits(private val repository: HabitRepository) {
    operator fun invoke(): Flow<List<Habit>> {
        return repository.getAllHabits()
    }

}