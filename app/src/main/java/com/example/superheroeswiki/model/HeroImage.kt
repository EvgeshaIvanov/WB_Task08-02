package com.example.superheroeswiki.model

import com.google.gson.annotations.SerializedName

data class HeroImage(
    @SerializedName("url")
    val url: String
)
