package com.imthiyas.focusmate.domain.usecase

import com.imthiyas.focusmate.domain.model.Habit
import com.imthiyas.focusmate.domain.repository.HabitRepository

class AddHabit(
    private val repository: HabitRepository
) {
    suspend operator fun invoke(habit: Habit) {
        repository.addHabit(habit)
    }

}