package com.example.data.repository


import com.example.data.R
import com.example.domain.model.HockeyModel
import com.example.domain.repository.HockeyRepository

class HockeyRepositoryMock(): HockeyRepository {
    override fun getImageTeamFirs(): HockeyModel {
            return HockeyModel("Kraken", "Akva", "0", "2",
            "1", 12, 12, "Beka Saved Shot Aiba", "Beka",
               "")
    }


}