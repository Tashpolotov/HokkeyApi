package com.example.domain.repository

import com.example.domain.model.GameAvailable
import com.example.domain.model.HockeyGame



interface HockeyRepository {

    fun getLiveGames() : List<GameAvailable>

    fun getPastGames() : List<GameAvailable>

    fun getLiveGame(id: String) : List<HockeyGame?>

    fun unlockGame(id: String)

}