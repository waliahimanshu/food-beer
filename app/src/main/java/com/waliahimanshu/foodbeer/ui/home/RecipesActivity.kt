package com.waliahimanshu.foodbeer.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.himanshuw.foodbeer.controls.AnimationHelper
import com.waliahimanshu.foodbeer.ui.R

class RecipesActivity : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(context: Context): Intent {
            return Intent(context, RecipesActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState).also {
        setContentView(R.layout.activity_recpies)

        AnimationHelper.sharedTransitionsExclude(window)

        if (savedInstanceState != null) {
            return
        }
        supportFragmentManager.beginTransaction().add(R.id.recipes_root, RecipesFragment.newInstance()).commit()
    }
}
