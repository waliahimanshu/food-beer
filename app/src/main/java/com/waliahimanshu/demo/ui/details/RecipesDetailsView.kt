package com.waliahimanshu.demo.ui.details

import android.annotation.SuppressLint
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.himanshuw.demo.controls.VerticalSwipeTouchListener
import com.waliahimanshu.demo.ui.R
import javax.inject.Inject



@SuppressLint("ClickableViewAccessibility")
class RecipesDetailsView @Inject constructor(private var view: View) : RecipesDetailsContract.View {

    private lateinit var recipesDetailsPresenter: RecipesDetailsContract.Presenter

    private val recipeImage = view.findViewById<ImageView>(R.id.detail_recipe_image)!!
    private val favButton = view.findViewById<ImageView>(R.id.fab_fav_border)
    private val profileName = view.findViewById<TextView>(R.id.detail_profile_name)
    private val profileDate = view.findViewById<TextView>(R.id.details_profile_date)
    private val recipeIngredient = view.findViewById<TextView>(R.id.details_item_ingredients)
    private val collapseButton: ImageView = view.findViewById(R.id.nav_close_button)

    init {
        favButton.setOnClickListener {
            recipesDetailsPresenter.onFavClick()
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
        val bottomUp = AnimationUtils.loadAnimation(view.context,
                R.anim.slide_up)
        recipeIngredient.startAnimation(bottomUp)
        recipeIngredient.visibility = View.VISIBLE
        recipeIngredient.text = recipeIngredients
    }
}

