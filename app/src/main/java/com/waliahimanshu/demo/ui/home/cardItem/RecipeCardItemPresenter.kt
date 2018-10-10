package com.waliahimanshu.demo.ui.home.cardItem

import android.widget.ImageView
import com.waliahimanshu.demo.ui.home.RecipesFragmentContract
import com.waliahimanshu.demo.ui.home.domain.Recipes
import com.waliahimanshu.demo.util.picasso.ImageLoader
import com.waliahimanshu.demo.util.picasso.ImageViewWrapper
import javax.inject.Inject

class RecipeCardItemPresenter @Inject constructor(private val itemView: RecipeCardItemContract.View,
                                                  private val imageLoader: ImageLoader,
                                                  private val interaction: RecipesFragmentContract.Interaction) : RecipeCardItemContract.Presenter {


    override fun init() {
        itemView.setPresenter(this)
    }

    override fun onClick(model: Recipes, recipeImage: ImageView) {
        interaction.onItemClick(model, recipeImage)
    }

    override fun bindData(model: Recipes, imageViewWrapper: ImageViewWrapper) {

        imageLoader.load(model.recipeImageUrl, imageViewWrapper.imageRecipe)
        imageLoader.load(model.personDto.profileImageRes, imageViewWrapper.imageProfile)

        with(model) {
            itemView.setModel(model)
            itemView.setProfileName(personDto.name)
            itemView.setProfileDate(personDto.date)
            itemView.setRecipeShortDesc(recipeIngredients)
        }
    }
}
