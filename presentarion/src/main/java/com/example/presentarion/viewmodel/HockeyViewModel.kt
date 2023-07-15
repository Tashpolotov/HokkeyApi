package com.example.presentarion.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.model.stateModel
import com.example.domain.usecase.HockeyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HockeyViewModel @Inject constructor(val useCase: HockeyUseCase):ViewModel() {

        private val _hockey = MutableStateFlow(stateModel(null, emptyList()))
        val hockey : StateFlow<stateModel> = _hockey

        fun loadHockeyGame() {
                val (account, message) = useCase.loadHockeyGame()
                _hockey.value = stateModel(account, message)
        }
}