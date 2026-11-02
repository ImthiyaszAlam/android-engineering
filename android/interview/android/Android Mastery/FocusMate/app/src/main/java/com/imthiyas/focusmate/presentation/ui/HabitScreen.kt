package com.imthiyas.focusmate.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import com.imthiyas.focusmate.domain.model.Habit
import com.imthiyas.focusmate.presentation.viewmodel.MainViewModel


@Composable

fun HabitScreen(mainViewModel: MainViewModel) {
    val habits by mainViewModel.habits.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(habits) { habit ->
                HabitCard(habit = habit)

            }

        }


        Spacer(modifier = Modifier.height(12.dp))


        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                mainViewModel.addHabit(
                    Habit(
                        title = "New Habit",
                        timeStamp = System.currentTimeMillis()
                    )
                )
            }
        ) {
            Text("Add Habit")
        }

    }
}


@Composable
fun HabitCard(habit: Habit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = habit.title, style = MaterialTheme.typography.titleMedium)
            Text(
                text = "Created At : ${habit.timeStamp}",
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}