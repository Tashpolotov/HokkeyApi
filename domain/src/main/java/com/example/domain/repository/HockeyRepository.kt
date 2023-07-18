package com.example.domain.repository

import com.example.domain.model.GameAvailable
import com.example.domain.model.HockeyGame
import kotlinx.coroutines.flow.StateFlow


interface HockeyRepository {

    fun getLiveGames() : List<GameAvailable>

    fun getPastGames() : List<GameAvailable>

    fun getLiveGame(id: String) : StateFlow<HockeyGame?>

    fun unlockGame(id: String)

}