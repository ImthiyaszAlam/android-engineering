package com.imthiyas.to_dolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("todo_table")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val isCompleted: Boolean = false
)