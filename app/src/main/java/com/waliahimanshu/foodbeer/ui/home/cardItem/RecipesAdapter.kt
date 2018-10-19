package com.waliahimanshu.foodbeer.ui.home.cardItem

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.waliahimanshu.foodbeer.ui.R
import com.waliahimanshu.foodbeer.ui.home.di.RecipeCardViewHolderFactory
import com.waliahimanshu.foodbeer.ui.home.domain.Recipes
import com.waliahimanshu.foodbeer.util.picasso.ImageViewWrapper
import javax.inject.Inject

class RecipesAdapter @Inject constructor(private val viewHolderFactory: RecipeCardViewHolderFactory.Builder) : RecyclerView.Adapter<RecipeCardViewHolder>() {

    private var models: List<Recipes> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeCardViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_list, parent, false)

        return viewHolderFactory.cardView(rootView).build().createViewHolder()
    }

    override fun onBindViewHolder(recipeCardViewHolder: RecipeCardViewHolder, position: Int) {
        val recipeEntryModel = models[position]
        val recipeImage = recipeCardViewHolder.itemView.findViewById<ImageView>(R.id.profile_recipe_image)
        val profileImage = recipeCardViewHolder.itemView.findViewById<ImageView>(R.id.profile_avatar)
        recipeCardViewHolder.bind(recipeEntryModel, ImageViewWrapper(recipeImage, profileImage))
    }

    override fun getItemCount(): Int {
        return models.size
    }

    fun bindData(map: List<Recipes>) {
        models = map
        notifyDataSetChanged()
    }
}
