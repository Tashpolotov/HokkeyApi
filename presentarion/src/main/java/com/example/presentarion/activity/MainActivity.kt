package com.example.presentarion.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.presentarion.R
import com.example.presentarion.fragment.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fr_container, HomeFragment()).commit()
    }
}