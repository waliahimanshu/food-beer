package com.waliahimanshu.demo.ui.home

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.waliahimanshu.demo.util.picasoo.ImageLoader
import javax.inject.Inject

class RecipeCardItemPresenter @Inject constructor(private val itemView: RecipeCardItemContract.View,
                                                  private val imageLoader: ImageLoader,
                                                  private val interaction: RecipesFragmentContract.Interaction) : RecipeCardItemContract.Presenter {


    override fun init() {
        itemView.setPresenter(this)
    }

    override fun onClick(model: Recipes, recipeImage: ImageView) {
        interaction.onItemClick(model)
    }

    override fun bindData(model: Recipes) {
//        imageLoader.load(model.recipeImageUrl, imageRequest.imageRecipe)
//        imageLoader.load(model.personModel.profileImageRes, imageRequest.imageProfile)
//
        val get = Picasso.get()
        get.setIndicatorsEnabled(true)
        get.load(model.recipeImageUrl).into(itemView.exposeRecipeImage())
        get.load(model.personModel.profileImageRes).into(itemView.exposeProfileImage())

        with(model) {
            itemView.setModel(model)
            itemView.setProfileName(personModel.name)
            itemView.setProfileDate(personModel.date)
            itemView.setRecipeShortDesc(recipeIngredients)
        }
    }
}
