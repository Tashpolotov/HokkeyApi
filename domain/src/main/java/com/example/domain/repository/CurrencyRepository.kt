package com.example.domain.repository

import com.example.domain.model.Currency

interface CurrencyRepository {

    fun balance () : Currency

    fun balancePlus ()

    fun balanceMinus(value : Int)

}