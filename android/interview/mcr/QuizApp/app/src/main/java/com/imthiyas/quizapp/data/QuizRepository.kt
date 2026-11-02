package com.imthiyas.quizapp.data

import com.imthiyas.quizapp.models.Question
import javax.inject.Inject

class QuizRepository @Inject constructor(private val api: QuizApi) {
    suspend fun fetchQuestions(): List<Question> {
        return api.getQuestions().results.map {
            Question(it.question, it.correctAnswer, it.incorrectAnswer)
        }
    }
}