package com.example.superheroeswiki.model

import com.google.gson.annotations.SerializedName

data class HeroResults(
    @SerializedName("results") val results: List<HeroData>
)
