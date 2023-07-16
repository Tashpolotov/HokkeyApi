package com.example.data.repository

import com.example.domain.model.HockeyPlayerModel
import com.example.domain.model.HockeyTeamModel
import com.example.domain.repository.HockeyRepository


class HockeyRepositoryMock(): HockeyRepository {

    override fun saveHockeyScore(hockeyTeam: HockeyTeamModel) {

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