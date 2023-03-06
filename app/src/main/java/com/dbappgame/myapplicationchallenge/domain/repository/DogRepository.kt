package com.dbappgame.myapplicationchallenge.domain.repository

import com.dbappgame.myapplicationchallenge.domain.model.Dog
import com.dbappgame.myapplicationchallenge.domain.model.Resource

interface DogRepository {
    suspend fun getDog(): Resource<Dog>
}