package com.waliahimanshu.demo.ui.home.cardItem

import android.widget.ImageView
import com.waliahimanshu.demo.ui.home.domain.Recipes
import com.waliahimanshu.demo.util.picasso.ImageViewWrapper

interface RecipeCardItemContract {
    interface Presenter{
        fun bindData(model: Recipes, imageViewWrapper: ImageViewWrapper)
        fun onClick(model: Recipes, recipeImage: ImageView)
        fun init()
    }
    interface View {
        fun setRecipeShortDesc(string: String)
        fun setProfileName(name: String)
        fun setProfileDate(date: String)
        fun setPresenter(recipeCardItemPresenter: Presenter)
        fun setModel(model: Recipes)
    }
}
