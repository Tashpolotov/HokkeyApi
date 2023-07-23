package com.example.hokkeyapi.module

import com.example.data.repository.HockeyCurrencyMock
import com.example.data.repository.HockeyRepositoryMock
import com.example.domain.repository.CurrencyRepository
import com.example.domain.repository.HockeyRepository
import com.example.domain.usecase.UnlockGameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TestModule {

    @Provides
    @Singleton
    fun provideHockeyRepository(): HockeyRepository {
        return HockeyRepositoryMock()
    }

    @Provides
    @Singleton
    fun provideCurrencyRepository(): CurrencyRepository {
        return HockeyCurrencyMock()
    }

    @Provides
    fun provideUnlockGameUseCase(
        hockeyRepository: HockeyRepository,
        currencyRepository: CurrencyRepository
    ): UnlockGameUseCase {
        return UnlockGameUseCase(hockeyRepository, currencyRepository)
    }

}