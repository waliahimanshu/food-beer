package com.waliahimanshu.demo.ui.home

import com.waliahimanshu.demo.network.PersonModel
import com.waliahimanshu.demo.network.RecipesDTO
import javax.inject.Inject

class RecipeEntryMapper @Inject constructor() {
    fun map(allRecipes: List<RecipesDTO>, profiles: ArrayList<PersonModel>): List<Recipes> {

        val arrayList = ArrayList<Recipes>()

        for ((index, it) in allRecipes.withIndex()) {
            val item = profiles[index]
            val personModel = PersonModel(item.name, item.date, item.profileImageRes)
            arrayList.add(Recipes(it.imageUrl, personModel, it.ingredients.toString()))
        }
        return arrayList
    }

}
