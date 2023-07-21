package com.example.presentarion.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.presentarion.databinding.FragmentCoinBinding
import com.example.presentarion.viewmodel.HockeyViewModel
import com.github.nisrulz.sensey.Sensey
import com.github.nisrulz.sensey.ShakeDetector
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
@AndroidEntryPoint
class CoinFragment : Fragment() {

    private lateinit var coinImageView: ImageView
    private lateinit var binding: FragmentCoinBinding
    private val viewModel by viewModels<HockeyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCoinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinImageView = binding.imgCoin

        Sensey.getInstance().init(requireContext())
        val shakeListener: ShakeDetector.ShakeListener = object : ShakeDetector.ShakeListener {
            override fun onShakeDetected() {
                viewModel.increaseBalance()
                animateCoin()
            }

            override fun onShakeStopped() {

            }

        }
        Sensey.getInstance().startShakeDetection(shakeListener)


        lifecycleScope.launchWhenCreated {
            viewModel.balance.collect { balance ->
                balance?.let {
                    binding.tvBalacne.text = it.balance.toString()
                }
            }
        }


    }

    override fun onDestroyView() {
        Sensey.getInstance().stop()
        super.onDestroyView()
        Sensey.getInstance()
    }

    private fun animateCoin() {
        coinImageView.animate()
            .rotationBy(360f)
            .setDuration(1000)
            .start()
    }
}