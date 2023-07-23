package com.example.presentarion.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.UnlockGameUseCase
import com.example.presentarion.model.HockeyViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import javax.inject.Inject
@HiltViewModel
class HockeyViewModel @Inject constructor(val useCase: UnlockGameUseCase): ViewModel() {

    private val _state = MutableStateFlow(HockeyViewState())
    val state: StateFlow<HockeyViewState> = _state.asStateFlow()

    init {
        loadBalance()
    }

    fun unlockGame() {
        useCase.currencyRepository.balanceMinus(50)
        loadBalance()
    }

    fun increaseBalance() {
        useCase.currencyRepository.balancePlus()
        loadBalance()
    }

    private fun loadBalance() {
        val balanceNew = useCase.currencyRepository.balance()
        _state.value = _state.value.copy(balance = balanceNew)
    }

    fun loadLiveGames() {
        val games = useCase.hockeyRepository
        _state.value = _state.value.copy(liveGames = games.getLiveGames())
    }

    fun loadPastGames() {
        val games = useCase.hockeyRepository
        _state.value = _state.value.copy(pastGames = games.getPastGames())
    }

    fun loadGameDetails(id: String) {
        val game = useCase.hockeyRepository
        _state.value = _state.value.copy(gameDetails = game.getLiveGame(id))


    }

    fun loadGamePast(id: String) {
        val gamePast = useCase.hockeyRepository
        _state.value = _state.value.copy(loadGamePast = gamePast.getPastGame(id))
    }
}