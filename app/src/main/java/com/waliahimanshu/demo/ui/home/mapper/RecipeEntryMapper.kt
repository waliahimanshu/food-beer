package com.waliahimanshu.demo.ui.home.mapper

import com.waliahimanshu.demo.ui.home.domain.Recipes
import com.waliahimanshu.demo.ui.home.dto.PersonDto
import com.waliahimanshu.demo.ui.home.dto.RecipesDTO
import javax.inject.Inject

class RecipeEntryMapper @Inject constructor() {
    fun map(allRecipes: List<RecipesDTO>, profiles: List<PersonDto>): List<Recipes> {

        val arrayList = ArrayList<Recipes>()

        for ((index, it) in allRecipes.withIndex()) {
            val item = profiles[index]
            val personModel = PersonDto(item.name, item.date, item.profileImageRes)
            val recipeIngredients = it.ingredients.toString().trim('[', ']')
            arrayList.add(Recipes(it.recipeId, it.imageUrl, personModel, recipeIngredients, it.title, it.socialRank))
        }
        return arrayList
    }
}
