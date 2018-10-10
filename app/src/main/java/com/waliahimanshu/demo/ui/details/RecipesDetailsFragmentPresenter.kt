package com.waliahimanshu.demo.ui.details

import com.waliahimanshu.demo.ui.home.Recipes
import com.waliahimanshu.demo.util.picasoo.ImageLoader
import javax.inject.Inject

class RecipesDetailsFragmentPresenter @Inject constructor(private val view: RecipesDetailsContract.View,
                                                          private val imageLoader: ImageLoader) : RecipesDetailsContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun bindData(model: Recipes) {
        with(model) {
            view.setRecipeImage(recipeImageUrl)
            view.setProfileName(personModel.name)
            view.setProfileDate(personModel.date)
            view.setProfileImage(personModel.profileImageRes)
            view.setRecipeIngredients(recipeIngredients)
        }
    }

    override fun onFavClick() {

    }
}
