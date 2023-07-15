package com.example.presentarion.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.model.stateModel
import com.example.domain.repository.HockeyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HockeyViewModel @Inject constructor(val repository: HockeyRepository):ViewModel() {

        private val _hockey = MutableStateFlow(stateModel(null))
        val hockey : StateFlow<stateModel> = _hockey

        fun loadHockeyGame() {
                val result = repository.getImageTeamFirs()
                _hockey.value = stateModel(result)
        }
}