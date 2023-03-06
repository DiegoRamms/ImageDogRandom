package com.dbappgame.myapplicationchallenge.data.repository

import com.dbappgame.myapplicationchallenge.data.mapper.toDomain
import com.dbappgame.myapplicationchallenge.data.service.DogService
import com.dbappgame.myapplicationchallenge.domain.model.Dog
import com.dbappgame.myapplicationchallenge.domain.model.Resource
import com.dbappgame.myapplicationchallenge.domain.repository.DogRepository
import javax.inject.Inject

class DogRepositoryImp @Inject constructor(private val dogService: DogService): DogRepository {
    override suspend fun getDog(): Resource<Dog> {
        return try {
            Resource.Success(dogService.getDog().toDomain())
        }catch (e: Exception){
            Resource.Error(message = "Error message")
        }
    }
}