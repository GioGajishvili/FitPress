package com.example.finalproject.classes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class UserInfo(
    val name: String = "",
    val surname: String = "",
    var height: String = "",
    val weight: String = "",
    var age: String = "",
    ) : Parcelable
