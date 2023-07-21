package com.example.presentarion.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        supportFragmentManager.beginTransaction().replace(R.id.fr_container, HomeFragment())
            .commit()

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