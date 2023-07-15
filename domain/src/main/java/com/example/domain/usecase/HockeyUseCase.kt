package com.example.domain.usecase

import com.example.domain.model.HockeyModel
import com.example.domain.model.HockeyTeamModel
import com.example.domain.repository.HockeyRepository

class HockeyUseCase(private val repository: HockeyRepository) {


    fun loadHockeyGame() : Pair<HockeyModel, List<HockeyTeamModel>> {
        val team = repository.getImageTeamFirs()
        val score = repository.getResultTeam()
        return Pair(team, score)
    }
}