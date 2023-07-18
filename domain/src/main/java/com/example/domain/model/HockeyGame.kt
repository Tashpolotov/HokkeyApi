package com.example.domain.model

data class HockeyGame(
    val id : String,
    val scoreFirstTeam: Int,
    val scoreSecondTeam: Int,
    val firstTeam: HockeyTeam,
    val secondTeam: HockeyTeam,
    val stateGame: GameState,

)

sealed interface GameAvailable {
        class OpenGame(val game : HockeyGame) : GameAvailable

        class HiddenGame(val firstTeam: HockeyTeam, val secondTeam: HockeyTeam, val id: String) : GameAvailable
}

sealed interface GameState{

    class LiveGame(val time: Long, val part: Int) : GameState

    class PastGame : GameState
}