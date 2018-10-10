package com.waliahimanshu.demo.ui.home

import android.support.v7.widget.RecyclerView
import android.view.View
import javax.inject.Inject

class RecipeCardViewHolder @Inject constructor(private val recipeCardItemPresenter: RecipeCardItemPresenter,
                                               rootItemView: View)
    : RecyclerView.ViewHolder(rootItemView) {

    fun bind(recipeModel: Recipes, imageViewWrapper: ImageViewWrapper) {
        recipeCardItemPresenter.init()
        recipeCardItemPresenter.bindData(recipeModel, imageViewWrapper)
    }
}
