package com.example.fragmentsviewmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Options(var text: String): Parcelable {
    companion object {
        @JvmStatic
        val DEFAULT = Options("default")
    }
}