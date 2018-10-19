package com.waliahimanshu.foodbeer.ui.home.dto

import android.os.Parcelable
import android.support.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonDto(
        val name: String,
        val date: String,
        @DrawableRes val profileImageRes: Int
) : Parcelable
