package com.imthiyas.quizapp.models

data class Question(
    val question: String,
    val correctAnswer: String,
    val incorrectAnswer: List<String>
)

data class QuizResponse(
    val responseCode: Int,
    val results: List<Question>
)

