package com.waliahimanshu.demo.ui.details

import com.waliahimanshu.demo.ui.home.Recipes
import javax.inject.Inject

class RecipesDetailsFragmentPresenter @Inject constructor(private val view: RecipesDetailsContract.View) : RecipesDetailsContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun bindData(model: Recipes) {
        with(model) {
            view.setRecipeImage(recipeImageUrl)
            view.setProfileName(personModel.name)
            view.setProfileDate(personModel.date)
            view.setProfileImage(personModel.profileImageRes)
            //todo
            val recipeIngredients1 = recipeIngredients
            view.setRecipeIngredients(recipeIngredients1)
        }
    }

    override fun onFavClick() {

    }
}
