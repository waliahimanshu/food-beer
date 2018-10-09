package com.waliahimanshu.demo.ui.details

import com.waliahimanshu.demo.ui.home.Recipes

interface RecipesDetailsContract {
    interface Presenter {
        fun bindData(model: Recipes)
        fun onFavClick()
    }

    interface View {
        fun setRecipeImage(recipeImageUrl: String)
        fun setProfileName(name: String)
        fun setProfileImage(name: Int)
        fun setRecipeIngredients(recipeIngredients: String)
        fun setProfileDate(name: String)
        fun setPresenter(presenter: RecipesDetailsContract.Presenter)
    }
}

