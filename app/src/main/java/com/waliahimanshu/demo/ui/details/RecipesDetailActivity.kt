package com.waliahimanshu.demo.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.himanshuw.demo.controls.SharedTransitionSystemBars
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.ui.home.EXTRA_RECIPE_IMAGE_TRANSITION_NAME
import com.waliahimanshu.demo.ui.home.EXTRA_RECIPE_ITEM
import com.waliahimanshu.demo.ui.home.domain.Recipes

class RecipesDetailActivity : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(context: Context, recipeModel: Recipes, transitionName: String): Intent {
            val intent = Intent(context, RecipesDetailActivity::class.java)
            intent.putExtra(EXTRA_RECIPE_ITEM, recipeModel)
            intent.putExtra(EXTRA_RECIPE_IMAGE_TRANSITION_NAME, transitionName)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState).also {
        setContentView(R.layout.activity_recpies_details)

        supportPostponeEnterTransition()

        SharedTransitionSystemBars.exclude(window)

        val parcelableExtra = intent.getParcelableExtra<Recipes>(EXTRA_RECIPE_ITEM)

        val stringExtra = intent.getStringExtra(EXTRA_RECIPE_IMAGE_TRANSITION_NAME)

        supportFragmentManager.beginTransaction().add(R.id.recipes_detail_root, RecipesDetailsFragment.newInstance(parcelableExtra, stringExtra)).commit()

        supportStartPostponedEnterTransition()
    }
}
