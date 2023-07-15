package com.example.presentarion.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.model.HockeyTeamModel
import com.example.domain.model.StateModel
import com.example.domain.repository.HockeyRepository
import com.example.domain.usecase.HockeyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HockeyViewModel @Inject constructor(private val useCase: HockeyUseCase):ViewModel() {

        private val _hockey = MutableStateFlow(StateModel(null, null))
        val hockey : StateFlow<StateModel> = _hockey

        fun loadHockeyGame() {
                val (team, player) = useCase.loadHockeyGame()
                _hockey.value = StateModel(team, player)
        }
}