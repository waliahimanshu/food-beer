package com.waliahimanshu.foodbeer.ui.home.domain

import android.os.Parcelable
import com.waliahimanshu.foodbeer.ui.home.dto.PersonDto
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Recipes(var recipeId: String,
                   var recipeImageUrl: String,
                   var personDto: PersonDto,
                   var recipeIngredients: String,
                   var title: String,
                   var rank: String) : Parcelable
