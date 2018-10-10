package com.waliahimanshu.demo.ui.home

import android.widget.ImageView
import com.waliahimanshu.demo.ui.home.domain.Recipes

interface RecipesFragmentContract {

    interface Presenter {
        fun loadData()
        fun onStop()
    }

    interface View {
        fun bindData(recipes: List<Recipes>)
        fun showError()
    }

    interface Interaction {
        fun onItemClick(selectedModel: Recipes, recipeImage: ImageView)
    }
}
