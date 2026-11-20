package com.imthiyas.quizapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imthiyas.quizapp.data.QuizRepository
import com.imthiyas.quizapp.models.Question
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuizViewModel @Inject constructor(private val repository: QuizRepository) : ViewModel() {

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> get() = _questions

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> get() = _score


    fun loadQuestions() {
        viewModelScope.launch {
            _questions.value = repository.fetchQuestions()
        }
    }

    fun increaseScore() {
        _score.value = (_score.value ?: 0) + 10
    }

}