package com.example.presentarion.viewmodel

import com.example.domain.model.HockeyTeamModel
import javax.inject.Inject

class HockeyScoreModelMapperImpl @Inject constructor() : HockeyScoreModelMapper {
    override fun mapToDomainModel(hockeyScore: HockeyScoreModel): HockeyTeamModel {


        val teamModel = HockeyTeamModel(
             hockeyScore.imgFirstTeam,
             hockeyScore.imgSecondteam,
             hockeyScore.scoreFirstTeam.toString(),
             hockeyScore.scoreSecondTeam.toString(),
             hockeyScore.part.toString(),
             hockeyScore.time.toLong(),
             hockeyScore.time.toLong()
        )


        return teamModel
    }
}