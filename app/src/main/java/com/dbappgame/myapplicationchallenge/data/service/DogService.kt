package com.dbappgame.myapplicationchallenge.data.service

import com.dbappgame.myapplicationchallenge.data.model.DogDTO
import retrofit2.http.GET

interface DogService {
    @GET("breeds/image/random")
    suspend fun getDog(): DogDTO
}