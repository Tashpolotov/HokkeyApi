package com.example.presentarion.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Currency
import com.example.domain.model.GameAvailable
import com.example.domain.model.HockeyGame
import com.example.domain.model.HockeyTeam
import com.example.domain.repository.HockeyRepository
import com.example.domain.usecase.UnlockGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HockeyViewModel @Inject constructor(val useCase: UnlockGameUseCase): ViewModel() {

    private val _liveGames = MutableStateFlow<List<GameAvailable>>(emptyList())
    val liveGames: StateFlow<List<GameAvailable>> = _liveGames

    private val _pastGames = MutableStateFlow<List<GameAvailable>>(emptyList())
    val pastGames: StateFlow<List<GameAvailable>> = _pastGames

    private val _gameDetails = MutableStateFlow<List<HockeyGame?>>(emptyList())
    val gameDetails: StateFlow<List<HockeyGame?>> = _gameDetails

    private val _balance = MutableStateFlow(Currency(0))
    val balance: StateFlow<Currency> = _balance

    private val _balanceNew = MutableStateFlow<Currency?>(null)
    val balanceNew: StateFlow<Currency?> = _balanceNew

    private val _coin = MutableStateFlow(Currency(0))
    val coin: StateFlow<Currency> = _coin


        fun unlockGame() {
            Log.e("HockeyViewModel", "Unlocking game - starting balance: ${_coin.value?.balance}")
            useCase.currencyRepository.balanceMinus(50)
            Log.e("HockeyViewModel", "Unlocking game - updated balance: ${_coin.value?.balance}")
        }

        fun increaseBalance() {
            Log.e(
                "HockeyViewModel",
                "Increasing balance - starting balance: ${_balance.value?.balance}"
            )
            useCase.currencyRepository.balancePlus()
            Log.e(
                "HockeyViewModel",
                "Increasing balance - updated balance: ${_balance.value?.balance}"
            )
            updateBalance()
        }

        fun loadBalance() {
            val balanceNew = useCase.currencyRepository.balance()
            _balance.value = balanceNew

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
    fun updateBalance() {
        viewModelScope.launch {
            val balanceNew = useCase.currencyRepository.balance()
            _balance.value = balanceNew
        }

    }
}