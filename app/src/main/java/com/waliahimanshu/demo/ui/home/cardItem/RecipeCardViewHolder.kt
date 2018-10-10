package com.waliahimanshu.demo.ui.home.cardItem

import android.support.v7.widget.RecyclerView
import android.view.View
import com.waliahimanshu.demo.ui.home.domain.Recipes
import com.waliahimanshu.demo.util.picasso.ImageViewWrapper
import javax.inject.Inject

class RecipeCardViewHolder @Inject constructor(private val recipeCardItemPresenter: RecipeCardItemPresenter,
                                               rootItemView: View)
    : RecyclerView.ViewHolder(rootItemView) {

    fun bind(recipeModel: Recipes, imageViewWrapper: ImageViewWrapper) {
        recipeCardItemPresenter.init()
        recipeCardItemPresenter.bindData(recipeModel, imageViewWrapper)
    }
}
