package com.example.data.repository

import android.util.Log
import com.example.domain.model.Currency
import com.example.domain.repository.CurrencyRepository

    class HockeyCurrencyMock: CurrencyRepository  {

        var currency = 0

        override fun balance(): Currency {
            return Currency(currency)

            Log.e("HockeyCurrencyMock", "Updated balance: $currency")
        }

        override fun balancePlus() {
            currency += 5
            Log.e("HockeyCurrencyMock", "Updated balance: $currency")
        }

        override fun balanceMinus(value: Int) {
            currency = currency - value
            Log.e("HockeyCurrencyMock", "Updated balance: $currency")
        }
    }