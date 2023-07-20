package com.example.presentarion.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.presentarion.databinding.FragmentCoinBinding
import com.github.nisrulz.sensey.Sensey
import com.github.nisrulz.sensey.ShakeDetector

class CoinFragment : Fragment() {

    private lateinit var coinImageView: ImageView
    private lateinit var shakeDetector: ShakeDetector
    private lateinit var binding: FragmentCoinBinding

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

        shakeDetector = ShakeDetector(object : ShakeListener {
            override fun onShakeDetected() {
                animateCoin()
            }

            override fun onShakeStopped() {
                animateCoin()
            }
        })


    }

    override fun onDestroyView() {
        Sensey.getInstance().stop()
        super.onDestroyView()
    }

    private fun animateCoin() {
        coinImageView.animate()
            .rotationBy(360f)
            .setDuration(1000)
            .start()
    }
}