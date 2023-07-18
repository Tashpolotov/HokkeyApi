package com.example.presentarion.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.presentarion.databinding.FragmentGameDetailsBinding
import com.example.presentarion.viewmodel.HockeyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetailsFragment : Fragment() {

    private lateinit var binding: FragmentGameDetailsBinding
    private val viewModel: HockeyViewModel by viewModels()
    private var gameId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvGameId.text = gameId

        gameId = arguments?.getString("gameId")

        gameId?.let {
            viewModel.loadGameDetails(it)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.gameDetails.collect { game ->
                game?.let {

                    binding.tvScoreFirstTeam.text = game.scoreFirstTeam.toString()
                    binding.tvScoreSecondTeam.text = game.scoreSecondTeam.toString() }
            }
        }
    }

}