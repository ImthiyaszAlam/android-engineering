package com.imthiyas.focusmate.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.imthiyas.focusmate.domain.model.Habit


@Entity(tableName = "habits")
data class HabitEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val timeStamp: Long = System.currentTimeMillis()
)


fun HabitEntity.toHabit(): Habit {
    return Habit(id = id, title = title, timeStamp = timeStamp)
}

fun Habit.toEntity(): HabitEntity {
    return HabitEntity(id = id, title = title, timeStamp = timeStamp)
}