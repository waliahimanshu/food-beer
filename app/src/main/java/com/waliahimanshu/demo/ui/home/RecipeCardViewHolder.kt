package com.waliahimanshu.demo.ui.home

import android.support.v7.widget.RecyclerView
import android.view.View

class RecipeCardViewHolder(private val recipeCardItemPresenter: RecipeCardItemPresenter, rootItemView: View)
    : RecyclerView.ViewHolder(rootItemView) {

    fun bind(recipeModel: Recipes) {
        recipeCardItemPresenter.bindData(recipeModel)
    }
}
