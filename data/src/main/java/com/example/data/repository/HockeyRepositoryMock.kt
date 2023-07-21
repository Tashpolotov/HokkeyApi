package com.example.data.repository

import com.example.domain.model.*
import com.example.domain.repository.HockeyRepository


class HockeyRepositoryMock : HockeyRepository {


    override fun getLiveGames(): List<GameAvailable> {
        val liveGamesList = mutableListOf<GameAvailable>()
        val game1 = HockeyGame(
            "game1", 1, 3,
            HockeyTeam("game1", "Liverpool", ""),
            HockeyTeam("game1", "Chelsea", ""),
            GameState.LiveGame(8, 1)
        )
        val openGame1 = GameAvailable.OpenGame(game1)
        liveGamesList.add(openGame1)

        val game2 = HockeyGame(
            "game2", 1, 8,
            HockeyTeam("game2", "Aiba", ""),
            HockeyTeam("game2", "Beka", ""),
            GameState.LiveGame(1, 1)
        )
        val openGame2 = GameAvailable.OpenGame(game2)
        liveGamesList.add(openGame2)


        val hiddenGame1 = GameAvailable.HiddenGame(
            HockeyTeam("game3", "Nurba", ""),
            HockeyTeam("game3", "Bek", ""),
            "game3"
        )
        liveGamesList.add(hiddenGame1)

        val hiddenGame2 = GameAvailable.HiddenGame(

            HockeyTeam("game4", "Manas", ""),
            HockeyTeam("game4", "Mika", ""),
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
                HockeyTeam("game6", "men", ""),
                HockeyTeam("game6", "sen", ""),
                GameState.PastGame()
            )
        )
        pastGameList.add(pastGame1)

        val pastGame2 = GameAvailable.OpenGame(
            HockeyGame(
                "game6", 7, 0,
                HockeyTeam("game7", "alma", ""),
                HockeyTeam("game7", "pi9z", ""),
                GameState.PastGame()
            )
        )
        pastGameList.add(pastGame2)

        return pastGameList
    }

    override fun getLiveGame(id: String): List<HockeyGame> {
        val gamesList = mutableListOf<HockeyGame>()

        val game1 = HockeyGame(
            "game1", 1, 3,
            HockeyTeam("game1", "Liverpool", ""),
            HockeyTeam("game1", "Chelsea", ""),
            GameState.LiveGame(8, 1)
        )
        gamesList.add(game1)

        val game2 = HockeyGame(
            "game2", 1, 8,
            HockeyTeam("game2", "Aiba", ""),
            HockeyTeam("game2", "Beka", ""),
            GameState.LiveGame(1, 1)
        )
        gamesList.add(game2)

        val game3 = HockeyGame(
            "game3", 1, 3,
            HockeyTeam("game3", "Nurba", ""),
            HockeyTeam("game3", "Bek", ""),
            GameState.LiveGame(8, 1)
        )
        gamesList.add(game3)

        val game4 = HockeyGame(
            "game4", 1, 3,
            HockeyTeam("game4", "Manas", ""),
            HockeyTeam("game4", "Mika", ""),
            GameState.LiveGame(8, 1)
        )
        gamesList.add(game4)


        return gamesList
    }

    override fun getTutorial(): List<HockeyTutorial> {
        return listOf(
            HockeyTutorial(
                "Nevada", 6, "вратарь", "Защищает ворота команды"),
            HockeyTutorial(
                "Nevada", 6, "Защитник", "Защищает вратаря и свои ворота от шайбы участвует в атаке"
            ),
            HockeyTutorial(
                "Nevada", 6, "Нападающий", "Участвует в атаке и забивает голы"
            )
        )
    }

    override fun unlockGame(id: String) {

    }
}