package com.himanshuw.demo.controls

import android.transition.Fade
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import himanshuw.com.demo.ui_controls.R

object AnimationHelper {

    fun sharedTransitionsExclude(window: Window) {
        val fade = Fade()
        fade.excludeTarget(android.R.id.statusBarBackground, true)
        fade.excludeTarget(android.R.id.navigationBarBackground, true)
        window.enterTransition = fade
        window.exitTransition = fade
    }

    fun slideUpFromBottom(view: View) {
        val bottomUp = AnimationUtils.loadAnimation(view.context, R.anim.slide_up)
        view.startAnimation(bottomUp)
        view.visibility = View.VISIBLE
    }

}
