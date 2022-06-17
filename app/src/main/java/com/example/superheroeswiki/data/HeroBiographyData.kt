package com.example.superheroeswiki.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroBiographyData(
    @SerializedName("fullName") var fullName: String,
    @SerializedName("placeOfBirth") val placeOfBirth: String,
    @SerializedName("publisher") val publisher: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    companion object : Parceler<HeroBiographyData> {

        override fun HeroBiographyData.write(parcel: Parcel, flags: Int) {
            parcel.writeString(fullName)
            parcel.writeString(placeOfBirth)
            parcel.writeString(publisher)
        }

        override fun create(parcel: Parcel): HeroBiographyData {
            return HeroBiographyData(parcel)
        }
    }

}
