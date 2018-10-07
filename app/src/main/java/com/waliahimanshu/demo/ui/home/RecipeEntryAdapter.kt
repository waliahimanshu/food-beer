package com.waliahimanshu.demo.ui.home

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.util.picasoo.PicassoImageLoader
import javax.inject.Inject

class RecipeEntryAdapter @Inject constructor(
        private val imageLoader: PicassoImageLoader) : RecyclerView.Adapter<RecipeCardViewHolder>() {

    private lateinit var dataSet: List<RecipeModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_list, parent, false)
        return RecipeCardViewHolder(RecipeCardItemPresenter(RecipeCardItemView(view), imageLoader), view)

    }

    override fun onBindViewHolder(recipeCardViewHolder: RecipeCardViewHolder, position: Int) {
        val recipeEntryModel = dataSet[position]

        val imageView = recipeCardViewHolder.itemView.findViewById<ImageView>(R.id.profile_recipe_image)
        ViewCompat.setTransitionName(imageView, recipeEntryModel.recipeShortDescription)

        with(recipeCardViewHolder.itemView) {
            setOnClickListener {
//                onItemClickListener?.onItemClick(recipeEntryModel, imageView)
            }
        }
        recipeCardViewHolder.bind(recipeEntryModel)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun bindData(map: List<RecipeModel>) {
        dataSet = map
    }
}
