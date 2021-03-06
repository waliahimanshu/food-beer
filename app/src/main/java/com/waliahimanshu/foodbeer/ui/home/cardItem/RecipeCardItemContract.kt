package com.waliahimanshu.foodbeer.ui.home.cardItem

import com.waliahimanshu.foodbeer.ui.home.domain.Recipes
import com.waliahimanshu.foodbeer.util.picasso.ImageViewWrapper

interface RecipeCardItemContract {
    interface Presenter{
        fun bindData(model: Recipes, imageViewWrapper: ImageViewWrapper)
        fun onClick(model: Recipes, recipeImage: ImageViewWrapper)
        fun init()
    }
    interface View {
        fun setRecipeIngredients(string: String)
        fun setProfileName(name: String)
        fun setProfileDate(date: String)
        fun setPresenter(recipeCardItemPresenter: Presenter)
        fun setModel(model: Recipes)
        fun setFavIcon(boolean: Boolean)
    }
}
