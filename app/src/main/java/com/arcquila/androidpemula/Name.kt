package com.arcquila.androidpemula

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(val name: String?, val last:String?) : Parcelable

