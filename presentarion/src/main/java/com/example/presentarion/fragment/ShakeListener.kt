package com.example.presentarion.fragment

import com.github.nisrulz.sensey.ShakeDetector

interface ShakeListener : ShakeDetector.ShakeListener {

    // Добавьте методы, которые вам необходимо обрабатывать при тряске экрана

    override fun onShakeDetected()
    override fun onShakeStopped()
}