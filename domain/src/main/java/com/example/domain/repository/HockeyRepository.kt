package com.example.domain.repository

import com.example.domain.model.GameAvailable
import com.example.domain.model.HockeyGame
import com.example.domain.model.HockeyTutorial


    interface HockeyRepository {


        fun getLiveGames() : List<GameAvailable>

        fun getPastGames() : List<GameAvailable>

        fun getLiveGame(id: String) : List<HockeyGame?>

        fun getPastGame(id: String) : List<HockeyGame?>

        fun unlockGame(id: String)

        fun getTutorial() : List<HockeyTutorial>

    }