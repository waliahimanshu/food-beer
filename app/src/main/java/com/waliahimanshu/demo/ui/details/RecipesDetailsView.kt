package com.waliahimanshu.demo.ui.details

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.waliahimanshu.demo.ui.R
import javax.inject.Inject

class RecipesDetailsView @Inject constructor(private var view: View) : RecipesDetailsContract.View {

    private lateinit var recipesDetailsPresenter: RecipesDetailsContract.Presenter

    private val recipeImage = view.findViewById<ImageView>(R.id.detail_recipe_image)!!
    private val favButton = view.findViewById<ImageView>(R.id.fab_fav_border)
    private val profileImage = view.findViewById<ImageView>(R.id.details_profile_image)
    private val profileName = view.findViewById<TextView>(R.id.detail_profile_name)
    private val profileDate = view.findViewById<TextView>(R.id.details_profile_date)
    private val recipeIngredient = view.findViewById<TextView>(R.id.details_item_ingredients)

    init {
        favButton.setOnClickListener {
            recipesDetailsPresenter.onFavClick()
        }
    }

    //TODO remove picasso
    override fun setRecipeImage(recipeImageUrl: String) {
        Picasso.get()
                .load(recipeImageUrl)
                .into(recipeImage)
    }

    override fun setPresenter(presenter: RecipesDetailsContract.Presenter) {
        recipesDetailsPresenter = presenter
    }

    override fun setProfileName(name: String) {
        profileName.text = name
    }

    override fun setProfileDate(name: String) {
        profileDate.text = name
    }

    override fun setRecipeIngredients(recipeIngredients: String) {
        recipeIngredient.text = recipeIngredients
    }

    override fun setProfileImage(name: Int) {
        Picasso.get()
                .load(name)
                .into(profileImage)
    }
}

