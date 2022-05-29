package com.example.superheroeswiki.model

import com.google.gson.annotations.SerializedName

data class HeroAppearanceData(
    @SerializedName("gender") val gender: String,
    @SerializedName("race") val race: String
)
