package com.example.superheroeswiki

import com.google.gson.annotations.SerializedName


data class HeroResults(
    @SerializedName("results") val results: List<HeroData>
)

data class HeroData(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("biography") val biography: HeroBiographyData,
    @SerializedName("image") val image: HeroImage,
    @SerializedName("appearance") val appearance: HeroAppearanceData
)

data class HeroBiographyData(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    @SerializedName("publisher") val publisher: String
)

data class HeroAppearanceData(
    @SerializedName("gender") val gender: String,
    @SerializedName("race") val race: String
)

data class HeroImage(
    @SerializedName("url")
    val url: String
)

