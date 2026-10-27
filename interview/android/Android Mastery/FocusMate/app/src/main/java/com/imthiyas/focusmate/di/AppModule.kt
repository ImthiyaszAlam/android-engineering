package com.imthiyas.focusmate.di

import android.app.Application
import androidx.room.Room
import com.imthiyas.focusmate.data.local.HabitDao
import com.imthiyas.focusmate.data.local.HabitDatabase
import com.imthiyas.focusmate.data.repository.HabitRepositoryImpl
import com.imthiyas.focusmate.domain.repository.HabitRepository
import com.imthiyas.focusmate.domain.usecase.AddHabit
import com.imthiyas.focusmate.domain.usecase.GetAllHabits
import com.imthiyas.focusmate.domain.usecase.HabitUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): HabitDatabase {
        return Room.databaseBuilder(app, HabitDatabase::class.java, "habit_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideHabitDao(db: HabitDatabase): HabitDao {
        return db.habitDao()
    }

    @Provides
    @Singleton
    fun provideHabitRepository(dao: HabitDao): HabitRepository {
        return HabitRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideHabitUseCases(repository: HabitRepository): HabitUseCases {
        return HabitUseCases(
            getAllHabits = GetAllHabits(repository),
            addHabit = AddHabit(repository)
        )
    }
}
