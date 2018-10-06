package com.waliahimanshu.demo.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.waliahimanshu.demo.ui.R

class RecipesDetailActivity : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(context: Context): Intent {
            return Intent(context, RecipesDetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState).also {
        setContentView(R.layout.activity_recpies_details)

//        supportFragmentManager.
//                beginTransaction().
//                add(R.id.recipes_detail_root, RecipesDetailsFragment.newInstance(,"")).
//                commit()
    }
}
