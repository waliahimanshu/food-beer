package com.waliahimanshu.demo.ui.home.dto

import com.google.gson.annotations.SerializedName


data class RecipesDTO(
        @SerializedName("image_url") val imageUrl: String,
        @SerializedName("f2f_url") val f2fUrl: String?,
        @SerializedName("ingredients") val ingredients: List<String>,
        @SerializedName("title") val title: String,
        @SerializedName("recipe_id") val recipeId: String
)

