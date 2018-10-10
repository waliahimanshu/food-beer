package com.waliahimanshu.demo.ui.details

import com.waliahimanshu.demo.ui.home.ImageViewWrapper
import com.waliahimanshu.demo.ui.home.Recipes

interface RecipesDetailsContract {
    interface Presenter {
        fun bindData(model: Recipes, imageViewWrapper: ImageViewWrapper)
        fun onFavClick()
        fun onCollapseClick()
    }

    interface View {
        fun setProfileName(name: String)
        fun setRecipeIngredients(recipeIngredients: String)
        fun setProfileDate(name: String)
        fun setPresenter(presenter: RecipesDetailsContract.Presenter)
    }

    interface Interaction {
        fun onCollapseClick()
    }
}

