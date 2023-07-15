package com.example.presentarion.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.HockeyModel
import com.example.presentarion.R
import com.example.presentarion.adapter.HockeyAdapter
import com.example.presentarion.databinding.FragmentHomeBinding
import com.example.presentarion.viewmodel.HockeyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = HockeyAdapter()
    private val viewModel by viewModels<HockeyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
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

    private fun init() {
    lifecycleScope.launchWhenCreated {
        viewModel.hockey.collect{
            it.game.let {
                binding.tvLiveTeamName.text = it?.firstTeamScore
                binding.tvTeamSecondName.text = it?.nameSecondTeam
                binding.tvLiveTime.text = it?.liveTime.toString()
                binding.tvLivePart.text = it?.part.toString()
                binding.tvScroll.text = it?.firstTeamScore
                binding.tvSecondTeamScroll.text = it?.secondTeamScore
                binding.tvNamePlayer.text = it?.namePlayer
                binding.tvLiveShotSaveGoal.text = it?.titleSavePlayer

            }
        }
    }
        viewModel.loadHockeyGame()
    }

    private fun adapterInit() {
        binding.rvHomeLive.adapter = adapter
    }



}