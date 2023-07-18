package com.example.presentarion.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.domain.model.HockeyGame
import com.example.presentarion.R
import com.example.presentarion.adapter.HockeyAdapter
import com.example.presentarion.adapter.HockeyPasteGameAdapter
import com.example.presentarion.databinding.FragmentHomeBinding
import com.example.presentarion.viewmodel.HockeyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = HockeyAdapter()
    private val viewModel by viewModels<HockeyViewModel>()
    private val adapterPasteGame = HockeyPasteGameAdapter(this::onClickItem)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initView()
        initAdapter()
        binding.rvHomeLive.adapter = adapter
    }

    private fun initAdapter() {
        binding.rvHomeLive.adapter = adapter
        binding.rvHomeLast.adapter = adapterPasteGame
    }

    private fun initView() {
        adapterPasteGame.onClick = this::onClickItem
    }

    private fun init() {
        lifecycleScope.launchWhenCreated {
            viewModel.liveGames.collect { liveGames ->
                adapter.submitList(liveGames)
            }
        }
        lifecycleScope.launchWhenCreated {
            viewModel.pastGames.collect { pastGames ->
                adapterPasteGame.submitList(pastGames)
            }
        }
        viewModel.loadLiveGames()
        viewModel.loadPastGames()
    }

    private fun onClickItem(id: String) {
        val bundle = Bundle().apply {
            putString("gameId", id)
        }
        val gameDetailsFragment = GameDetailsFragment()
        gameDetailsFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fr_container, gameDetailsFragment)
            .addToBackStack(null)
            .commit()
    }
}