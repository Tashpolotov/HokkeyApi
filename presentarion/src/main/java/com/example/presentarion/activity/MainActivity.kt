package com.example.presentarion.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import com.example.presentarion.R
import com.example.presentarion.databinding.ActivityMainBinding
import com.example.presentarion.fragment.CoinFragment
import com.example.presentarion.fragment.GameDetailsFragment
import com.example.presentarion.fragment.HockeyTutorialFragment
import com.example.presentarion.fragment.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, HomeFragment())
                .commit()
        }

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, HomeFragment())
                        .addToBackStack("homeFragmentTransaction")
                        .commit()
                    Log.e("beka", "Navigated to HomeFragment")
                    true
                }
                R.id.menu_item_anim -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, CoinFragment())
                        .addToBackStack("coinFragmentTransaction")
                        .commit()
                    Log.e("beka", "Navigated to CoinFragment")
                    true
                }
                R.id.menu_item_info -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, HockeyTutorialFragment())
                        .addToBackStack("hockeyTutorialFragmentTransaction")
                        .commit()
                    Log.e("beka", "Navigated to HockeyTutorialFragment")
                    true
                }
                else -> false
            }
        }
    }
}