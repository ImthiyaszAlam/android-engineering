package com.imthiyas.focusmate.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertHabit(habit: HabitEntity)


    @Query("SELECT * FROM habits ORDER by timeStamp Desc")
    fun getAllHabits(): Flow<List<HabitEntity>>
}