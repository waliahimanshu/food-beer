package com.waliahimanshu.demo.ui.home

import android.os.Parcelable
import com.waliahimanshu.demo.network.PersonModel
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Recipes(var recipeImageUrl: String, var personModel: PersonModel, var recipeIngredients: String) : Parcelable
