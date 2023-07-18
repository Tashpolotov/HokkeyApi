package com.example.data.repository

import com.example.domain.model.Currency
import com.example.domain.repository.CurrencyRepository

    class HockeyCurrencyMock: CurrencyRepository  {

        var currency = 100

        override fun balance(): Currency {
            return Currency(currency)
        }

        override fun balancePlus() {
            currency += 5
        }

        override fun balanceMinus(value: Int) {
            currency = currency - value
        }
    }