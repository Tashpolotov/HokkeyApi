package com.example.data.repository

import com.example.domain.model.HockeyPlayerModel
import com.example.domain.model.HockeyTeamModel
import com.example.domain.repository.HockeyRepository
import com.example.presentarion.model.HockeyScoreModel


class HockeyRepositoryMock(private val team: HockeyScoreModel): HockeyRepository {
    override fun saveHockeyScore(hockeyTeam: HockeyTeamModel) {
         HockeyScoreModel("", "", 1, 5, 2, 85)

    }


    override fun getImageTeamFirs(): HockeyTeamModel {
        return HockeyTeamModel(
            "Kraken", "Akva", "0", "2",
            "1", 12, 12
        )

    }
    override fun getPlayer(): HockeyPlayerModel {
        return HockeyPlayerModel("Beka saved Shot Aiba", "Beka", "")
    }

}