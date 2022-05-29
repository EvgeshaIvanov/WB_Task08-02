package com.example.superheroeswiki.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class HeroData(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("biography") val biography: HeroBiographyData,
    @SerializedName("image") val image: HeroImage,
    @SerializedName("appearance") val appearance: HeroAppearanceData
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(HeroBiographyData::class.java.classLoader)!!,
        parcel.readParcelable(HeroImage::class.java.classLoader)!!,
        parcel.readParcelable(HeroAppearanceData::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeParcelable(biography, flags)
        parcel.writeParcelable(image, flags)
        parcel.writeParcelable(appearance, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroData> {
        override fun createFromParcel(parcel: Parcel): HeroData {
            return HeroData(parcel)
        }

        override fun newArray(size: Int): Array<HeroData?> {
            return arrayOfNulls(size)
        }
    }
}









