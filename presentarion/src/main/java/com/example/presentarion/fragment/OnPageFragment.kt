package com.example.presentarion.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.presentarion.R
import com.example.presentarion.adapter.OnBoardAdapter
import com.example.presentarion.databinding.FragmentOnPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnPageFragment : Fragment() {

    private lateinit var binding: FragmentOnPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOnPageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardAdapter(requireActivity())
        adapter.also { it.also { binding.vp2Board.adapter = it } }
        binding.dotsIndicator.attachTo(binding.vp2Board)
    }
}