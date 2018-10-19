package com.waliahimanshu.foodbeer.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.himanshuw.foodbeer.controls.AnimationHelper
import com.waliahimanshu.foodbeer.ui.R
import com.waliahimanshu.foodbeer.ui.home.EXTRA_RECIPE_ITEM
import com.waliahimanshu.foodbeer.ui.home.domain.Recipes

class RecipesDetailActivity : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(context: Context, recipeModel: Recipes): Intent {
            val intent = Intent(context, RecipesDetailActivity::class.java)
            intent.putExtra(EXTRA_RECIPE_ITEM, recipeModel)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState).also {

        setContentView(R.layout.activity_recpies_details)

        supportPostponeEnterTransition()

        AnimationHelper.sharedTransitionsExclude(window)

        val parcelableExtra = intent.getParcelableExtra<Recipes>(EXTRA_RECIPE_ITEM)

        supportFragmentManager.beginTransaction().add(R.id.recipes_detail_root, RecipesDetailsFragment.newInstance(parcelableExtra)).commit()

        supportStartPostponedEnterTransition()
    }
}
