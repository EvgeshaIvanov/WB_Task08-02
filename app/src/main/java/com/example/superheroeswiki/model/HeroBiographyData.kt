package com.example.superheroeswiki.model

import com.google.gson.annotations.SerializedName

data class HeroBiographyData(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    @SerializedName("publisher") val publisher: String
)
