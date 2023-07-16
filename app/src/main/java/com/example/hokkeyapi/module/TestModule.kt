package com.example.hokkeyapi.module

import com.example.data.repository.HockeyRepositoryMock
import com.example.domain.repository.HockeyRepository
import com.example.domain.usecase.HockeyUseCase
import com.example.presentarion.model.HockeyScoreModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class TestModule {

    @Provides
    fun getRepository(hockeyScoreModel: HockeyScoreModel) : HockeyRepository{
        return HockeyRepositoryMock(hockeyScoreModel)

    }
    @Provides
    fun getUseCase(repository: HockeyRepository) : HockeyUseCase {
        return HockeyUseCase(repository)
    }

}