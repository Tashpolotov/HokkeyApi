package com.example.data.repository

import com.example.domain.model.GameAvailable
import com.example.domain.model.GameState
import com.example.domain.model.HockeyGame
import com.example.domain.model.HockeyTeam
import com.example.domain.repository.HockeyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map


class HockeyRepositoryMock : HockeyRepository {

    private val liveGames = MutableStateFlow<HockeyGame?>(null)

    override fun getLiveGames(): List<GameAvailable> {
        val liveGamesList = mutableListOf<GameAvailable>()
        val game1 = HockeyGame(
            "game1", 1, 3,
            HockeyTeam("game4", "Liverpool", ""),
            HockeyTeam("game7", "Chelsea", ""),
            GameState.LiveGame(0, 0)
        )
        val openGame1 = GameAvailable.OpenGame(game1)
        liveGamesList.add(openGame1)

        val game2 = HockeyGame(
            "game2", 1, 3,
            HockeyTeam("game1", "Aiba", ""),
            HockeyTeam("game1", "Beka", ""),
            GameState.LiveGame(1, 1)
        )
        val openGame2 = GameAvailable.OpenGame(game2)
        liveGamesList.add(openGame2)


        val hiddenGame1 = GameAvailable.HiddenGame(
            HockeyTeam("Team E", "Nurba", ""),
            HockeyTeam("Team F", "Bek", ""),
            "game3"
        )
        liveGamesList.add(hiddenGame1)

        val hiddenGame2 = GameAvailable.HiddenGame(

            HockeyTeam("Team G", "Manas", ""),
            HockeyTeam("Team H", "Mika", ""),
            "game4",
        )
        liveGamesList.add(hiddenGame2)

        return liveGamesList
    }

    override fun getPastGames(): List<GameAvailable> {
        val pastGameList = mutableListOf<GameAvailable>()
        val pastGame1 = GameAvailable.OpenGame(
            HockeyGame(
                "game5", 5, 8,
                HockeyTeam("Team I", "men", ""),
                HockeyTeam("Team J", "sen", ""),
                GameState.PastGame()
            )
        )
        pastGameList.add(pastGame1)

        val pastGame2 = GameAvailable.OpenGame(
            HockeyGame(
                "game6", 7, 0,
                HockeyTeam("Team K", "alma", ""),
                HockeyTeam("Team L", "pi9z", ""),
                GameState.PastGame()
            )
        )
        pastGameList.add(pastGame2)

        return pastGameList
    }

    override fun getLiveGame(id: String): MutableStateFlow<HockeyGame?> {
        return liveGames

    }

    override fun unlockGame(id: String) {

    }
}