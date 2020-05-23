package com.example.kotlin.models

import android.os.Parcel
import android.os.Parcelable

data class PersonComplete(val nombre: String?, val apellid: String?, val edad: Int, val bool: Boolean = true) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {

    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(apellid)
        parcel.writeInt(edad)
        parcel.writeByte(if (bool) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonComplete> {
        override fun createFromParcel(parcel: Parcel): PersonComplete {
            return PersonComplete(parcel)
        }

        override fun newArray(size: Int): Array<PersonComplete?> {
            return arrayOfNulls(size)
        }
    }
}