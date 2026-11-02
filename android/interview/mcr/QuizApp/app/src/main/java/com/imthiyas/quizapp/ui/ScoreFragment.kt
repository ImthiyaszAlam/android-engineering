package com.imthiyas.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.imthiyas.quizapp.R
import com.imthiyas.quizapp.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private val viewModel: QuizViewModel by viewModels()
    private lateinit var binding: FragmentScoreBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.score.observe(viewLifecycleOwner) { score ->
            binding.scoreText.text = "Final Score: $score"
        }

        binding.restartButton.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_quizFragment)
        }
    }


}