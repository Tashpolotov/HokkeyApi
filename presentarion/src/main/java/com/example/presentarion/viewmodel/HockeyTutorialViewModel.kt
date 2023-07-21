package com.example.presentarion.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.model.HockeyTutorial
import com.example.domain.usecase.UnlockGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HockeyTutorialViewModel @Inject constructor(val useCase: UnlockGameUseCase): ViewModel() {

    private val _tutorial = MutableStateFlow<List<HockeyTutorial>>(emptyList())
    val tutorial : StateFlow<List<HockeyTutorial>> = _tutorial


    fun loadTutorialHockey() {
        val result = useCase.hockeyRepository
        _tutorial.value = result.getTutorial()
    }

}