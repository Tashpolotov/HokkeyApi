package com.example.presentarion.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.model.Currency
import com.example.domain.model.GameAvailable
import com.example.domain.model.HockeyGame
import com.example.domain.model.HockeyTeam
import com.example.domain.repository.HockeyRepository
import com.example.domain.usecase.UnlockGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HockeyViewModel @Inject constructor(val useCase: UnlockGameUseCase): ViewModel() {

    private val _liveGames = MutableStateFlow<List<GameAvailable>>(emptyList())
    val liveGames: StateFlow<List<GameAvailable>> = _liveGames

    private val _pastGames = MutableStateFlow<List<GameAvailable>>(emptyList())
    val pastGames: StateFlow<List<GameAvailable>> = _pastGames

    private val _gameDetails = MutableStateFlow<List<HockeyGame?>>(emptyList())
    val gameDetails: StateFlow<List<HockeyGame?>> = _gameDetails

    private val _balance = MutableStateFlow<Currency?>(null)
    val balance : StateFlow<Currency?> = _balance
    private val _balanceNew = MutableStateFlow<Currency?>(null)
    val balanceNew : StateFlow<Currency?> = _balanceNew

    fun increaseBalance() {
        val currentBalance = _balance.value?.balance ?: 100
        val newBalance = currentBalance + 5
        _balance.value = Currency(newBalance)

    }
    fun loadBalance() {
        val balanceNew = useCase.currencyRepository.balance()
        _balanceNew.value = balanceNew
    }
    fun loadLiveGames() {

        val games = useCase.hockeyRepository
        _liveGames.value = games.getLiveGames()
    }

    fun loadPastGames() {
        val games = useCase.hockeyRepository
        _pastGames.value = games.getPastGames()
    }

    fun loadGameDetails(id: String) {
        val game = useCase.hockeyRepository
        _gameDetails.value = game.getLiveGame(id)
    }

}