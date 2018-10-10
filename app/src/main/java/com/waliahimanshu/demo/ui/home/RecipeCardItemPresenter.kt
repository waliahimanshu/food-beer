package com.waliahimanshu.demo.ui.home

import android.widget.ImageView
import com.waliahimanshu.demo.util.picasoo.ImageLoader
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
        imageLoader.load(model.personModel.profileImageRes, imageViewWrapper.imageProfile)

        with(model) {
            itemView.setModel(model)
            itemView.setProfileName(personModel.name)
            itemView.setProfileDate(personModel.date)
            itemView.setRecipeShortDesc(recipeIngredients)
        }
    }
}
