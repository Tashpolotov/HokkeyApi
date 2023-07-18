package com.example.domain.usecase

import com.example.domain.repository.CurrencyRepository
import com.example.domain.repository.HockeyRepository

class UnlockGameUseCase(val hockeyRepository: HockeyRepository, val currencyRepository: CurrencyRepository)   {

    operator fun invoke(id: String)  {
        hockeyRepository.unlockGame(id)
        currencyRepository.balanceMinus(10)

    }

}