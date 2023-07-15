package com.example.domain.usecase

import com.example.domain.model.HockeyPlayerModel
import com.example.domain.model.HockeyTeamModel
import com.example.domain.repository.HockeyRepository

class HockeyUseCase(private val  repository: HockeyRepository) {

    fun loadHockeyGame() : Pair<HockeyTeamModel, HockeyPlayerModel>{
        val team = repository.getImageTeamFirs()
        val player = repository.getPlayer()
        return Pair(team, player)

    }

}