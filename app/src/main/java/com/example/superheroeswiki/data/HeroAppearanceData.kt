package com.example.superheroeswiki.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroAppearanceData(
    @SerializedName("gender") val gender: String,
    @SerializedName("race") val race: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()
    )

    companion object : Parceler<HeroAppearanceData> {

        override fun HeroAppearanceData.write(parcel: Parcel, flags: Int) {
            parcel.writeString(gender)
            parcel.writeString(race)
        }

        override fun create(parcel: Parcel): HeroAppearanceData {
            return HeroAppearanceData(parcel)
        }
    }

}
