package com.example.presentarion.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.presentarion.R
import com.example.presentarion.adapter.OnBoardAdapter
import com.example.presentarion.databinding.ActivityMainBinding
import com.example.presentarion.fragment.*
import com.example.presentarion.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
    class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding

        @Inject
        lateinit var preferences: Preferences

        private lateinit var onBoardingCompletedKey: String

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            onBoardingCompletedKey = "onBoardingCompleted"
            val onBoardingCompleted = preferences.isBoardingShowed()

            binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
            setContentView(binding.root)

            if (!preferences.isBoardingShowed()){
                supportFragmentManager.beginTransaction().add(R.id.fr_container, OnPageFragment()).commit()
                binding.bottomNavView.visibility = View.GONE
            }else{
                supportFragmentManager.beginTransaction().add(R.id.fr_container, HomeFragment()).commit()
                binding.bottomNavView.visibility = View.VISIBLE
            }



            binding.bottomNavView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_item_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fr_container, HomeFragment())
                            .addToBackStack(null)
                            .commit()
                        true
                    }
                    R.id.menu_item_anim -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fr_container, CoinFragment())
                            .addToBackStack(null)
                            .commit()
                        true
                    }
                    R.id.menu_item_info -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fr_container, HockeyTutorialFragment())
                            .addToBackStack(null)
                            .commit()
                        true
                    }
                    else -> false
                }
            }

        }
    }