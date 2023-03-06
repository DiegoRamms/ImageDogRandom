package com.dbappgame.myapplicationchallenge.data.mapper

import com.dbappgame.myapplicationchallenge.data.model.DogDTO
import com.dbappgame.myapplicationchallenge.domain.model.Dog


fun DogDTO.toDomain(): Dog =
    Dog(message, status)