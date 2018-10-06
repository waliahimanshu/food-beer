package com.waliahimanshu.demo.ui.home

import android.os.Parcelable
import android.support.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonModel(
        val name: String,
        val date: String,
        @DrawableRes val profileImageRes: Int? = null
) : Parcelable
