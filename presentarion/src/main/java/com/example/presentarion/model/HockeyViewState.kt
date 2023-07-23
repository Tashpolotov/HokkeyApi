package com.example.presentarion.model

import com.example.domain.model.Currency
import com.example.domain.model.GameAvailable
import com.example.domain.model.HockeyGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HockeyViewState(
        val liveGames: List<GameAvailable> = emptyList(),
        val pastGames: List<GameAvailable> = emptyList(),
        val gameDetails: List<HockeyGame?> = emptyList(),
        val balance: Currency? = null,
        val loadGamePast: List<HockeyGame?> = emptyList()
)