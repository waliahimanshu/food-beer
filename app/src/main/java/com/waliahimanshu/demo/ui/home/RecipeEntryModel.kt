package com.waliahimanshu.demo.ui.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RecipeEntryModel(var recipeImageUrl: String, var personModel: PersonModel, var recipeShortDescription: String) : Parcelable
