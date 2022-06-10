package com.example.superheroeswiki.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeString(placeOfBirth)
        parcel.writeString(publisher)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroBiographyData> {
        override fun createFromParcel(parcel: Parcel): HeroBiographyData {
            return HeroBiographyData(parcel)
        }

        override fun newArray(size: Int): Array<HeroBiographyData?> {
            return arrayOfNulls(size)
        }
    }

}
