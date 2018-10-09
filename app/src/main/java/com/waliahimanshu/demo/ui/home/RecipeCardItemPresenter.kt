package com.waliahimanshu.demo.ui.home

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.waliahimanshu.demo.util.picasoo.PicassoImageLoader
import io.reactivex.functions.BiConsumer

class RecipeCardItemPresenter(private val itemView: RecipeCardItemContract.View,
                              private val imageLoader: PicassoImageLoader) : RecipeCardItemContract.Presenter {


    private lateinit var action: BiConsumer<Recipes, ImageView>
    private lateinit var interaction: RecipesFragmentContract.Interaction

    override fun init() {
        itemView.setPresenter(this)
    }

    fun setAction(action: BiConsumer<Recipes, ImageView>) {
        this.action = action
    }

    override fun setInteraction(fragmentInteraction: RecipesFragmentContract.Interaction) {
        this.interaction  = fragmentInteraction
    }

    override fun onClick(model: Recipes, recipeImage: ImageView) {
       interaction.onItemClick()
        action.accept(model, recipeImage)
    }


    override fun bindData(model: Recipes) {
//        imageLoader.load(model.recipeImageUrl, imageRequest.imageRecipe)
//        imageLoader.load(model.personModel.profileImageRes, imageRequest.imageProfile)
//
        val get = Picasso.get()
        get.setIndicatorsEnabled(true)
        get.load(model.recipeImageUrl).into(itemView.exposeRecipeImage())
        get.load(model.personModel.profileImageRes).into(itemView.exposeProfileImage())

        with(model) {
            itemView.setModel(model)
            itemView.setProfileName(personModel.name)
            itemView.setProfileDate(personModel.date)
            itemView.setRecipeShortDesc(recipeIngredients)
        }
    }
}
