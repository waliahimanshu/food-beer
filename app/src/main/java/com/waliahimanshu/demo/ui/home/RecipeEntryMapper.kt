package com.waliahimanshu.demo.ui.home

import com.waliahimanshu.demo.network.PersonModel
import com.waliahimanshu.demo.network.RecipeDTO
import javax.inject.Inject

class RecipeEntryMapper @Inject constructor() {
    fun map(allRecipes: List<RecipeDTO>, profiles: ArrayList<PersonModel>): List<RecipeModel> {

        val arrayList = ArrayList<RecipeModel>()

        for ((index, it) in allRecipes.withIndex()) {
            val item = profiles[index]
            val personModel = PersonModel(item.name, item.date, item.profileImageRes)
            arrayList.add(RecipeModel(it.imageUrl, personModel, it.ingredients.toString()))
        }
        return arrayList
    }

}
