package com.waliahimanshu.demo.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.util.picasoo.PicassoImageLoader
import io.reactivex.functions.BiConsumer
import javax.inject.Inject

class RecipesAdapter @Inject constructor(
        private val imageLoader: PicassoImageLoader) : RecyclerView.Adapter<RecipeCardViewHolder>() {

    var models: List<Recipes> = emptyList()

    private lateinit var action: BiConsumer<Recipes, ImageView>
    private lateinit var fragmentInteraction: RecipesFragmentContract.Interaction

    //todo mvp view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeCardViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_list, parent, false)
        val itemView = RecipeCardItemView(rootView)
        val itemPresenter = RecipeCardItemPresenter(itemView, imageLoader)
        itemPresenter.init()
        itemPresenter.setAction(action)
        itemPresenter.setInteraction(fragmentInteraction)
        return RecipeCardViewHolder(itemPresenter, rootView)
    }

    override fun onBindViewHolder(recipeCardViewHolder: RecipeCardViewHolder, position: Int) {
        val recipeEntryModel = models[position]
        recipeCardViewHolder.bind(recipeEntryModel)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    fun bindData(map: List<Recipes>) {
        models = map
        notifyDataSetChanged()
    }

    fun setAction(onClickAction: BiConsumer<Recipes, ImageView>) {
        this.action = onClickAction
    }

    fun setInteraction(fragmentInteraction: RecipesFragmentContract.Interaction) {
        this.fragmentInteraction = fragmentInteraction
    }
}
