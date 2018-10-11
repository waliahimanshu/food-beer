package com.himanshuw.demo.controls

import android.transition.Fade
import android.view.Window

object SharedTransitionSystemBars {

    fun exclude(window: Window) {
        val fade = Fade()
        fade.excludeTarget(android.R.id.statusBarBackground, true)
        fade.excludeTarget(android.R.id.navigationBarBackground, true)
        window.enterTransition = fade
        window.exitTransition = fade
    }
}
