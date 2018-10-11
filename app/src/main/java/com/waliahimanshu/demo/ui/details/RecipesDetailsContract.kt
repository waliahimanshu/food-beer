package com.waliahimanshu.demo.ui.details

import com.waliahimanshu.demo.ui.home.domain.Recipes
import com.waliahimanshu.demo.util.picasso.ImageViewWrapper

interface RecipesDetailsContract {
    interface Presenter {
        fun bindData(model: Recipes, imageViewWrapper: ImageViewWrapper)
        fun onFavClick(recipeId: String, selected: Boolean)
        fun onCollapseClick()
    }

    interface View {
        fun setProfileName(name: String)
        fun setRecipeIngredients(recipeIngredients: String)
        fun setProfileDate(name: String)
        fun setPresenter(presenter: RecipesDetailsContract.Presenter)
        fun setRecipeId(recipeId: String)
        fun setFavIcon(selected: Boolean)
    }

    interface Interaction {
        fun onCollapseClick()
    }
}

