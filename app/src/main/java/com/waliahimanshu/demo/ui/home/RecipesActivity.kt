package com.waliahimanshu.demo.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.himanshuw.demo.ui_controls.SharedTransitionFlash
import com.waliahimanshu.demo.ui.R

class RecipesActivity : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(context: Context): Intent {
            return Intent(context, RecipesActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState).also {
        setContentView(R.layout.activity_recpies)

        SharedTransitionFlash.fix(window)

        if (savedInstanceState != null) {
            return
        }
        supportFragmentManager.beginTransaction().add(R.id.recipes_root, RecipesFragment.newInstance()).commit()
    }
}
