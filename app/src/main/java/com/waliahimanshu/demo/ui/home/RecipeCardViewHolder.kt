package com.waliahimanshu.demo.ui.home

import android.support.v7.widget.RecyclerView
import android.view.View

class RecipeCardViewHolder(private val recipeCardItemPresenter: RecipeCardItemPresenter, itemView: View)
    : RecyclerView.ViewHolder(itemView) {


    fun bind(recipeModel: RecipeModel) {
        recipeCardItemPresenter.bindData(recipeModel)
    }
}
