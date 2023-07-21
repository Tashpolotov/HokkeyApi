package com.example.presentarion.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.presentarion.R
import com.example.presentarion.adapter.HockeyAdapter
import com.example.presentarion.adapter.HockeyPasteGameAdapter
import com.example.presentarion.databinding.FragmentHomeBinding
import com.example.presentarion.viewmodel.HockeyViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HockeyAdapter
    private val viewModel by viewModels<HockeyViewModel>()
    private val adapterPasteGame = HockeyPasteGameAdapter(this::onClickItem)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        Log.e("HomeFragment", "onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("HomeFragment", "onViewCreated")
        adapter = HockeyAdapter(viewModel, this::onClickItem)
        init()
        initView()
        initAdapter()
    }

    private fun initAdapter() {
        Log.e("HomeFragment", "initAdapter")
        binding.rvHomeLive.adapter = adapter
        binding.rvHomeLast.adapter = adapterPasteGame
    }

    private fun initView() {
        Log.e("HomeFragment", "initView")
        adapterPasteGame.onClick = this::onClickItem
    }

    private fun init() {
        Log.e("HomeFragment", "init")
        lifecycleScope.launchWhenCreated {
            viewModel.liveGames.collect {
                adapter.submitList(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.pastGames.collect {
                adapterPasteGame.submitList(it)
            }
        }

        viewModel.loadLiveGames()
        viewModel.loadPastGames()
    }

    private fun onClickItem(id: String) {
        Log.e("HomeFragment", "onClickItem")
        val bundle = Bundle().apply {
            putString("gameId", id)
        }
        val gameDetailsFragment = GameDetailsFragment()
        gameDetailsFragment.arguments = bundle

        // Важное замечание: здесь я заменил fragmentManager на childFragmentManager
        // чтобы правильно обрабатывать фрагменты, вложенные в другие фрагменты
        childFragmentManager.beginTransaction()
            .replace(R.id.fr_container, gameDetailsFragment)
            .addToBackStack(null)
            .commit()
    }
}