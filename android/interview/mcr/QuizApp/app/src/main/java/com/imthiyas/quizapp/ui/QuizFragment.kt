package com.imthiyas.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.imthiyas.quizapp.R
import com.imthiyas.quizapp.adapter.OptionsAdapter
import com.imthiyas.quizapp.databinding.FragmentQuizBinding
import com.imthiyas.quizapp.models.Question
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizFragment : Fragment() {


    private val viewModel: QuizViewModel by viewModels()
    private lateinit var binding: FragmentQuizBinding
    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadQuestions()

        viewModel.questions.observe(viewLifecycleOwner) { questions ->
            if (questions.isNotEmpty()) showQuestion(questions[currentIndex])
        }

        binding.nextButton.setOnClickListener {
            currentIndex++
            viewModel.questions.value?.let {
                if (currentIndex < it.size) showQuestion(it[currentIndex])
                else findNavController().navigate(R.id.action_quizFragment_to_scoreFragment)
            }
        }
    }

    private fun showQuestion(question: Question) {
        binding.questionText.text = question.question
        val allAnswers = question.incorrectAnswer + question.correctAnswer
        binding.optionsRecycler.adapter = OptionsAdapter(allAnswers) { selectedAnswer ->
            if (selectedAnswer == question.correctAnswer) viewModel.increaseScore()
        }
    }

}