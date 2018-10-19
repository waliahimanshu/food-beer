package com.waliahimanshu.foodbeer.ui.details

import com.waliahimanshu.foodbeer.ui.home.domain.Recipes
import com.waliahimanshu.foodbeer.util.PreferencesHelper
import com.waliahimanshu.foodbeer.util.picasso.ImageLoader
import com.waliahimanshu.foodbeer.util.picasso.ImageViewWrapper
import javax.inject.Inject

class RecipesDetailsFragmentPresenter @Inject constructor(private val view: RecipesDetailsContract.View,
                                                          private val imageLoader: ImageLoader,
                                                          private val interaction: RecipesDetailsContract.Interaction,
                                                          private val preferencesHelper: PreferencesHelper)
    : RecipesDetailsContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun bindData(model: Recipes, imageViewWrapper: ImageViewWrapper, twoPane: Int) {
        with(model) {

            imageLoader.load(recipeImageUrl, imageViewWrapper.imageRecipe)
            imageLoader.load(personDto.profileImageRes, imageViewWrapper.imageProfile)

            view.setProfileName(personDto.name)
            view.setProfileDate(personDto.date)
            view.setRecipeIngredients(recipeIngredients)
            view.setRecipeId(recipeId)
            view.setFavIcon(preferencesHelper.getValueBy(model.recipeId))

            if (twoPane == 2) {
                view.setRecipeName(model.title)
                view.setRecipeRank(model.rank)
            }
        }
    }

    override fun onFavClick(recipeId: String, selected: Boolean) {
        preferencesHelper.save(recipeId, selected)
        view.setFavIcon(selected)
    }

    override fun onCollapseClick() {
        interaction.onCollapseClick()
    }
}
