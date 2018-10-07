package com.waliahimanshu.demo.network

import com.google.gson.annotations.SerializedName


data class RecipeDTO(
        @SerializedName("image_url") val imageUrl: String,
        @SerializedName("f2f_url") val f2fUrl: String?,
        @SerializedName("ingredients") val ingredients: List<String>?,
        @SerializedName("title") val title: String
)

