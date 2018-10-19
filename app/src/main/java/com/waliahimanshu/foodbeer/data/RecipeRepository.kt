package com.waliahimanshu.foodbeer.data

import android.support.annotation.RawRes
import com.waliahimanshu.foodbeer.ui.R
import com.waliahimanshu.foodbeer.ui.home.dto.RecipesDTO
import io.reactivex.Single
import javax.inject.Inject

@RawRes
private const val recipesRes = R.raw.recipes_response

class RecipeRepository @Inject constructor(private val rawResourceWrapper: RawResourceWrapper, private val gsonWrapper: GsonWrapper) {

    fun getAllRecipes(): Single<List<RecipesDTO>> {
        return Single.fromCallable {
            val reader = rawResourceWrapper.openRawResource(recipesRes)
            gsonWrapper.fromJson(reader, Array<RecipesDTO>::class.java)!!.toList()
        }
    }
}


