package com.dbappgame.myapplicationchallenge.data.model


import com.google.gson.annotations.SerializedName

data class DogDTO(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)