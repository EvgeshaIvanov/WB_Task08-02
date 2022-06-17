package com.example.superheroeswiki.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroImage(
    @SerializedName("sm")
    val url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()!!)

    companion object : Parceler<HeroImage> {

        override fun HeroImage.write(parcel: Parcel, flags: Int) {
            parcel.writeString(url)
        }

        override fun create(parcel: Parcel): HeroImage {
            return HeroImage(parcel)
        }
    }

}
