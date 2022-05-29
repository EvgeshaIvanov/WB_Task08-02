package com.example.superheroeswiki.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class HeroResults(
    @SerializedName("results") val results: List<HeroData>
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(HeroData)!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroResults> {
        override fun createFromParcel(parcel: Parcel): HeroResults {
            return HeroResults(parcel)
        }

        override fun newArray(size: Int): Array<HeroResults?> {
            return arrayOfNulls(size)
        }
    }
}
