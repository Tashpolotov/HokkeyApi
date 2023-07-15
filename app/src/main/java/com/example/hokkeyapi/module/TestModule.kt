package com.example.hokkeyapi.module

import com.example.data.repository.HockeyRepositoryMock
import com.example.domain.repository.HockeyRepository
import com.example.domain.usecase.HockeyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class TestModule {

    @Provides
    fun getRepository() : HockeyRepository{
        return HockeyRepositoryMock()

    }
    @Provides
    fun getUseCase(repository: HockeyRepository) : HockeyUseCase {
        return HockeyUseCase(repository)
    }
}