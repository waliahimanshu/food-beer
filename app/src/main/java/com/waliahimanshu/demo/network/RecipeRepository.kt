package com.waliahimanshu.demo.network

import javax.inject.Inject


class RecipeRepository @Inject constructor(private val rawResourceWrapper: RawResourceWrapper, private val gsonWrapper: GsonWrapper) {


    fun getAllRecipes(id: Int): List<RecipeDTO> {
        val reader = rawResourceWrapper.openRawResource(id)

        //catch exception
        return gsonWrapper.fromJson(reader, Array<RecipeDTO>::class.java)!!.toList()
    }
}


