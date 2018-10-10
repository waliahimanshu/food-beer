package com.waliahimanshu.demo.ui.details

import com.waliahimanshu.demo.util.picasso.ImageViewWrapper
import com.waliahimanshu.demo.ui.home.domain.Recipes
import com.waliahimanshu.demo.util.picasso.ImageLoader
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
            imageLoader.load(personDto.profileImageRes, imageViewWrapper.imageProfile)

            view.setProfileName(personDto.name)
            view.setProfileDate(personDto.date)
            view.setRecipeIngredients(recipeIngredients)
        }
    }

    override fun onFavClick() {

    }

    override fun onCollapseClick() {
        interaction.onCollapseClick()
    }
}
