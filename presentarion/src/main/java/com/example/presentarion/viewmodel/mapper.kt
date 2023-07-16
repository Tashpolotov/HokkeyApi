package com.example.presentarion.viewmodel

import com.example.domain.model.HockeyTeamModel
import com.example.presentarion.model.HockeyScoreModel


interface HockeyScoreModelMapper {

    fun mapToDomainModel(hockeyScore: HockeyScoreModel): HockeyTeamModel

}

