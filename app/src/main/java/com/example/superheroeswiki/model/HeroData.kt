package com.example.superheroeswiki.model

import com.google.gson.annotations.SerializedName

data class HeroData(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("biography") val biography: HeroBiographyData,
    @SerializedName("image") val image: HeroImage,
    @SerializedName("appearance") val appearance: HeroAppearanceData
)







