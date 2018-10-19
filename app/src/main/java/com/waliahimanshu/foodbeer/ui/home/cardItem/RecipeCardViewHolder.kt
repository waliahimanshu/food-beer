package com.waliahimanshu.foodbeer.ui.home.cardItem

import android.support.v7.widget.RecyclerView
import android.view.View
import com.waliahimanshu.foodbeer.ui.home.domain.Recipes
import com.waliahimanshu.foodbeer.util.picasso.ImageViewWrapper
import javax.inject.Inject

class RecipeCardViewHolder @Inject constructor(private val recipeCardItemPresenter: RecipeCardItemPresenter,
                                               rootItemView: View)
    : RecyclerView.ViewHolder(rootItemView) {

    fun bind(recipeModel: Recipes, imageViewWrapper: ImageViewWrapper) {
        recipeCardItemPresenter.init()
        recipeCardItemPresenter.bindData(recipeModel, imageViewWrapper)
    }
}
