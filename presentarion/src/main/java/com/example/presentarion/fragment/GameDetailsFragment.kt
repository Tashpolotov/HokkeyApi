package com.example.presentarion.fragment

import android.os.Bundle
import android.util.Log
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

        gameId = arguments?.getString("gameId")

        lifecycleScope.launchWhenStarted {
            viewModel.gameDetails.collect { games ->
                val game = games.firstOrNull { it?.id == gameId }
                game?.let {
                    Log.e("GameDetailsFragment", "Received game: $game")

                    binding.tvScroll.text = it.scoreFirstTeam.toString()
                    binding.tvSecondTeamScroll.text = it.scoreSecondTeam.toString()
                    binding.tvTeamName.text = it.firstTeam.name
                    binding.tvTeamSecondName.text = it.secondTeam.name
                }
            }
        }

        gameId?.let {
            Log.e("GameDetailsFragment", "Loading game details for gameId: $it")
            viewModel.loadGameDetails(it)
        }
    }
}