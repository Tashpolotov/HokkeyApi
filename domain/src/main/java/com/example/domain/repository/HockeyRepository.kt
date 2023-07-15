package com.example.domain.repository

import com.example.domain.model.HockeyPlayerModel
import com.example.domain.model.HockeyTeamModel


interface HockeyRepository {

    fun getImageTeamFirs() : HockeyTeamModel

    fun getPlayer() : HockeyPlayerModel

}