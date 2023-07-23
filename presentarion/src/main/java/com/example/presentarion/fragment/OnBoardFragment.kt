package com.example.presentarion.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentTransaction
import com.example.presentarion.R
import com.example.presentarion.activity.MainActivity
import com.example.presentarion.databinding.FragmentOnBoardBinding
import com.example.presentarion.model.OnBoardModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.prefs.Preferences
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    @Inject
    lateinit var preferences: com.example.presentarion.utils.Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        arguments.let {
            val data = it?.getSerializable("board") as OnBoardModel
            binding.tvStazam.text = data.title
            binding.tvTitleBoard.text = data.titleText
            data.img?.let { it1 -> binding.imgBoard.setImageResource(it1) }
            binding.btnGetStarted.isVisible = data.isLast == true

            if (data.isLast==false){
                data.bg?.let { it1 -> binding.container.setBackgroundResource(it1) }
            }else{
                data.bg?.let { it1 -> binding.container.setBackgroundResource(it1) }
            }

        }

        binding.btnGetStarted.setOnClickListener{
            val fragmentManager = requireFragmentManager()
            fragmentManager.beginTransaction().replace(R.id.fr_container, HomeFragment()).commit()
            preferences.setBoardingShowed(true)
            (activity as? MainActivity)?.binding?.bottomNavView?.visibility = View.VISIBLE

        }
    }

}
