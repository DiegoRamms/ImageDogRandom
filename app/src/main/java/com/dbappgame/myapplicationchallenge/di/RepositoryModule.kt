package com.dbappgame.myapplicationchallenge.di

import com.dbappgame.myapplicationchallenge.data.repository.DogRepositoryImp
import com.dbappgame.myapplicationchallenge.domain.repository.DogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDogRepository(dogRepositoryImp: DogRepositoryImp): DogRepository

}