package com.example.presentarion.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.presentarion.adapter.HockeyAdapter
import com.example.presentarion.databinding.FragmentHomeBinding
import com.example.presentarion.model.HockeyScoreModel
import com.example.presentarion.viewmodel.HockeyViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = HockeyAdapter()
    private val viewModel by viewModels<HockeyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterInit()
        init()
    }

    private fun adapterInit() {
        val adapter = HockeyAdapter()
        binding.rvHomeLive.adapter = adapter


        // Создаем и заполняем список hockeyScoreList
        val hockeyScoreList: List<HockeyScoreModel> = listOf(
            HockeyScoreModel("", "", 2, 85, 15, 40),
            HockeyScoreModel("", "", 4, 80, 10, 60),
            HockeyScoreModel("", "", 1, 8, 7, 18)
        )
        adapter.submitList(hockeyScoreList)
    }


    private fun init() {
        lifecycleScope.launchWhenCreated {
            viewModel.hockey.collect { state ->
                state.team?.let { team ->
                    binding.tvLiveTeamName.text = team.firstTeamScore
                    binding.tvTeamSecondName.text = team.nameSecondTeam
                    binding.tvLiveTime.text = team.liveTime.toString()
                    binding.tvLivePart.text = team.part.toString()
                    binding.tvScroll.text = team.firstTeamScore
                    binding.tvSecondTeamScroll.text = team.secondTeamScore
                }

                state.player?.let { player ->
                    binding.tvNamePlayer.text = player.namePlayer
                    binding.tvLiveShotSaveGoal.text = player.titleSavePlayer
                }

            }


        }
        viewModel.loadHockeyGame()
    }
}