package com.example.presentarion.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.presentarion.R
import com.example.presentarion.fragment.OnBoardFragment
import com.example.presentarion.model.OnBoardModel
import dagger.hilt.android.qualifiers.ApplicationContext

class OnBoardAdapter(@ApplicationContext fragment: FragmentActivity): FragmentStateAdapter(fragment) {

    private val listBoarding = arrayOf(
        OnBoardModel(
            "Приложение о хоккее",
            R.drawable.image_backround,
            "Добро пожаловать в наше приложение",
            false
        ),
        OnBoardModel(
            "Здесь вы можете заработать деньги для открытия игр",
            R.drawable.img_1,
            "",
            false
        ),
        OnBoardModel(
            "Функции игроков во время матчей",
            R.drawable.img_onboard3,
            "Если хотите продолжить ползоваться нашим приложением нажмите кнопки Started",
            true
        )
    )

    override fun getItemCount(): Int = listBoarding.size

    override fun createFragment(position: Int): Fragment {
        val data = bundleOf("board" to listBoarding[position])
        val fragment = OnBoardFragment()
        fragment.arguments = data
        return fragment
    }
}