package com.waliahimanshu.foodbeer.ui.home.cardItem

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.waliahimanshu.foodbeer.ui.R
import com.waliahimanshu.foodbeer.ui.R.id.*
import com.waliahimanshu.foodbeer.ui.home.domain.Recipes
import com.waliahimanshu.foodbeer.util.picasso.ImageViewWrapper
import javax.inject.Inject

class RecipeCardItemView @Inject constructor(view: View) : RecipeCardItemContract.View {

    private val recipeImage = view.findViewById<ImageView>(profile_recipe_image)
    private val recipeIngredient = view.findViewById<TextView>(recipe_ingredients)
    private var profileTitle = view.findViewById<TextView>(profile_tile)
    private var profileDate = view.findViewById<TextView>(profile_date)
    private var fav = view.findViewById<ImageView>(recipe_fav)

    private lateinit var presenter: RecipeCardItemContract.Presenter

    private lateinit var model: Recipes

    init {
        recipeImage.setOnClickListener {
            presenter.onClick(model, ImageViewWrapper(recipeImage))
        }
    }

    override fun setModel(model: Recipes) {
        this.model = model
    }

    override fun setFavIcon(boolean: Boolean) {
        if (boolean) {
            fav.setImageResource(R.drawable.ic_favorite_red_24dp)
        } else {
            fav.setImageResource(R.drawable.ic_favorite_border_grey_24dp)
        }
    }

    override fun setPresenter(recipeCardItemPresenter: RecipeCardItemContract.Presenter) {
        this.presenter = recipeCardItemPresenter
    }

    override fun setRecipeIngredients(string: String) {
        recipeIngredient.text = string
    }

    override fun setProfileName(name: String) {
        profileTitle.text = name
    }

    override fun setProfileDate(date: String) {
        profileDate.text = date
    }
}

