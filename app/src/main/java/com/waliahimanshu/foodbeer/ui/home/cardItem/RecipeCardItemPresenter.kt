package com.waliahimanshu.foodbeer.ui.home.cardItem

import com.waliahimanshu.foodbeer.ui.home.RecipesFragmentContract
import com.waliahimanshu.foodbeer.ui.home.domain.Recipes
import com.waliahimanshu.foodbeer.util.PreferencesHelper
import com.waliahimanshu.foodbeer.util.picasso.ImageLoader
import com.waliahimanshu.foodbeer.util.picasso.ImageViewWrapper
import javax.inject.Inject

class RecipeCardItemPresenter @Inject constructor(private val itemView: RecipeCardItemContract.View,
                                                  private val imageLoader: ImageLoader,
                                                  private val interaction: RecipesFragmentContract.Interaction,
                                                  private val sharedPreferences: PreferencesHelper)
    : RecipeCardItemContract.Presenter {


    override fun init() {
        itemView.setPresenter(this)
    }

    override fun onClick(model: Recipes, recipeImage: ImageViewWrapper) {
        interaction.onItemClick(model, recipeImage = recipeImage.imageRecipe)
    }

    override fun bindData(model: Recipes, imageViewWrapper: ImageViewWrapper) {

        imageLoader.load(model.recipeImageUrl, imageViewWrapper.imageRecipe)
        imageLoader.load(model.personDto.profileImageRes, imageViewWrapper.imageProfile)

        with(model) {
            itemView.setModel(model)
            itemView.setProfileName(personDto.name)
            itemView.setProfileDate(personDto.date)
            itemView.setRecipeIngredients(recipeIngredients)
            itemView.setFavIcon(sharedPreferences.getValueBy(model.recipeId))
        }
    }
}
