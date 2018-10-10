package com.waliahimanshu.demo.ui.home.cardItem

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.waliahimanshu.demo.ui.R.id.*
import com.waliahimanshu.demo.ui.home.domain.Recipes
import javax.inject.Inject

class RecipeCardItemView @Inject constructor(private val view: View) : RecipeCardItemContract.View {

    private val recipeImage = view.findViewById<ImageView>(profile_recipe_image)
    private val recipeIngredient = view.findViewById<TextView>(recipe_ingredients)
    private var profileTitle = view.findViewById<TextView>(profile_tile)
    private var profileDate = view.findViewById<TextView>(profile_date)

    private lateinit var presenter: RecipeCardItemContract.Presenter

    private lateinit var model: Recipes

    init {
        recipeImage.setOnClickListener {
            presenter.onClick(model, recipeImage)
        }
    }

    override fun setModel(model: Recipes) {
        this.model = model
    }

    override fun setPresenter(recipeCardItemPresenter: RecipeCardItemContract.Presenter) {
        this.presenter = recipeCardItemPresenter
    }

    override fun setRecipeShortDesc(string: String) {
        recipeIngredient.text = string
    }

    override fun setProfileName(name: String) {
        profileTitle.text = name
    }

    override fun setProfileDate(date: String) {
        profileDate.text = date
    }
}

