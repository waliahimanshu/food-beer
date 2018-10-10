package com.waliahimanshu.demo.ui.home.domain

import android.os.Parcelable
import com.waliahimanshu.demo.ui.home.dto.PersonDto
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Recipes(var recipeImageUrl: String, var personDto: PersonDto, var recipeIngredients: String) : Parcelable
