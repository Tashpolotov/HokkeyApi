package com.example.domain.model

data class HockeyTeamModel(
    val nameFistTeam:String,
    val nameSecondTeam:String,
    val firstTeamScore: String,
    val secondTeamScore:String,
    val part: String,
    val liveTime:Long,
    val timeMinut: Long,
)
