package com.example.superheroeswiki.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize


@Parcelize
data class HeroData(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("biography") val biography: HeroBiographyData,
    @SerializedName("images") val image: HeroImage,
    @SerializedName("appearance") val appearance: HeroAppearanceData
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(HeroBiographyData::class.java.classLoader)!!,
        parcel.readParcelable(HeroImage::class.java.classLoader)!!,
        parcel.readParcelable(HeroAppearanceData::class.java.classLoader)!!
    )

    companion object : Parceler<HeroData> {

        override fun HeroData.write(parcel: Parcel, flags: Int) {
            parcel.writeString(id)
            parcel.writeString(name)
            parcel.writeParcelable(biography, flags)
            parcel.writeParcelable(image, flags)
            parcel.writeParcelable(appearance, flags)
        }

        override fun create(parcel: Parcel): HeroData {
            return HeroData(parcel)
        }
    }
}









