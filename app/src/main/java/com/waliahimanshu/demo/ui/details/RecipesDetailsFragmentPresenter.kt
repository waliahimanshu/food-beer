package com.waliahimanshu.demo.ui.details

import com.waliahimanshu.demo.ui.home.ImageViewWrapper
import com.waliahimanshu.demo.ui.home.Recipes
import com.waliahimanshu.demo.util.picasoo.ImageLoader
import javax.inject.Inject

class RecipesDetailsFragmentPresenter @Inject constructor(private val view: RecipesDetailsContract.View,
                                                          private val imageLoader: ImageLoader,
                                                          private val interaction: RecipesDetailsContract.Interaction)
    : RecipesDetailsContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun bindData(model: Recipes, imageViewWrapper: ImageViewWrapper) {
        with(model) {

            imageLoader.load(recipeImageUrl,imageViewWrapper.imageRecipe)
            imageLoader.load(personModel.profileImageRes, imageViewWrapper.imageProfile)

            view.setProfileName(personModel.name)
            view.setProfileDate(personModel.date)
            view.setRecipeIngredients(recipeIngredients)
        }
    }

    override fun onFavClick() {

    }

    override fun onCollapseClick() {
        interaction.onCollapseClick()
    }
}
