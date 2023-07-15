package com.example.domain.model

data class HockeyModel(
    val nameFistTeam:String,
    val nameSecondTeam:String,
    val firstTeamScore: String,
    val secondTeamScore:String,
    val part: String,
    val liveTime:Long,
    val timeMinut: Long,
    val titleSavePlayer : String,
    val namePlayer: String,
    val imgPlayer : String
)

data class HockeyTeamModel(
    val imgFirstTeam: String,
    val imgSecondteam: String,
    val scoreFirstTeam: Int,
    val scoreSecondTeam: Int,
    val part : Int,
    val time: Int
)
