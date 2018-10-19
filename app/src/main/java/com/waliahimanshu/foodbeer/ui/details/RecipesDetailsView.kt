package com.waliahimanshu.foodbeer.ui.details

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.himanshuw.foodbeer.controls.AnimationHelper
import com.himanshuw.foodbeer.controls.VerticalSwipeTouchListener
import com.waliahimanshu.foodbeer.ui.R
import javax.inject.Inject


@SuppressLint("ClickableViewAccessibility")
class RecipesDetailsView @Inject constructor(private var view: View) : RecipesDetailsContract.View {

    private lateinit var recipesDetailsPresenter: RecipesDetailsContract.Presenter
    private lateinit var recipeId: String


    private val recipeImage = view.findViewById<ImageView>(R.id.detail_recipe_image)!!
    private val favButton = view.findViewById<ImageView>(R.id.fab_fav_border)
    private val profileName = view.findViewById<TextView>(R.id.detail_profile_name)
    private val profileDate = view.findViewById<TextView>(R.id.details_profile_date)
    private val recipeIngredient = view.findViewById<TextView>(R.id.details_item_ingredients)
    private val collapseButton: ImageView = view.findViewById(R.id.nav_close_button)


    //extra fields shown in land mode
    private val recipeTitle: TextView? = view.findViewById(R.id.recipe_title)
    private val recipeRank: TextView? = view.findViewById(R.id.recipe_rank)


    init {
        favButton.setOnClickListener {
            favButton.isSelected = !favButton.isSelected
            recipesDetailsPresenter.onFavClick(recipeId, favButton.isSelected)
        }

        collapseButton.setOnClickListener {
            recipesDetailsPresenter.onCollapseClick()
        }

        recipeImage.setOnTouchListener(object : VerticalSwipeTouchListener(view.context) {
            val myActivity = view.context as RecipesDetailActivity
            override fun onSwipeDown() {

                myActivity.finishAfterTransition()
            }

            override fun onSwipeUp() {
                myActivity.finishAfterTransition()
            }
        })
    }

    override fun setFavIcon(selected: Boolean) {
        favButton.isSelected = selected
        if (selected) {
            favButton.setImageResource(R.drawable.ic_favorite_red_24dp)
        } else {
            favButton.setImageResource(R.drawable.ic_favorite_border_grey_24dp)
        }
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
        AnimationHelper.slideUpFromBottom(recipeIngredient)
        recipeIngredient.text = recipeIngredients
    }

    override fun setRecipeName(title: String) {
        recipeTitle?.text = title
    }

    override fun setRecipeRank(rank: String) {
        recipeRank?.text = rank

    }

    override fun setRecipeId(recipeId: String) {
        this.recipeId = recipeId
    }
}

