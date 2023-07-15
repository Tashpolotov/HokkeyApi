package com.example.domain.repository

import com.example.domain.model.HockeyModel
import com.example.domain.model.HockeyTeamModel

interface HockeyRepository {

    fun getImageTeamFirs() : HockeyModel

    fun getResultTeam() : List<HockeyTeamModel>
}