package com.waliahimanshu.demo.ui.login

import android.animation.ArgbEvaluator
import android.os.Bundle
import android.support.transition.TransitionManager
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.ui.home.RecipesActivity

class WalkthroughActivity : AppCompatActivity() {
    /**
     * The [ViewPager] that will host the section contents.
     */
    private var page = 0

    private lateinit var viewPager: ViewPager
    private lateinit  var indicators: Array<ImageView>
    private lateinit var signUpButton: Button
    private lateinit var startButton: Button
    private lateinit var colorList: IntArray

    private var evaluator = ArgbEvaluator()
    private var color1: Int = 0
    private var color2: Int = 0
    private var color3: Int = 0

    private lateinit var transitionContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        transitionContainer = findViewById(R.id.button_container)
        signUpButton = findViewById(R.id.button_sign_up)
        startButton = findViewById(R.id.button_start)

        // Set up the ViewPager with the sections adapter.
        setUpViewPager()

        initColors()

       indicators = arrayOf(findViewById(R.id.intro_indicator_0), findViewById(R.id.intro_indicator_1),
                findViewById(R.id.intro_indicator_2))

        indicators.let {
            it[0].setBackgroundResource(R.drawable.active_indicator)
        }

        startButton.setOnClickListener {
            startActivity(RecipesActivity.getLaunchIntent(this))
        }

        hideStatusBar()
    }

    private fun hideStatusBar() {
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.decorView.systemUiVisibility = uiOptions
    }


    private fun setUpViewPager() {
        viewPager = findViewById(R.id.sections_view_pager)
        viewPager.adapter = SectionsPagerAdapter(supportFragmentManager)


        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixel: Int) {
                val colorUpdate = evaluator.evaluate(
                        positionOffset,

                        colorList[position],
                        colorList[if (position == 2) position else position + 1]) as Int
                viewPager.setBackgroundColor(colorUpdate)
            }

            override fun onPageSelected(position: Int) {
                page = position
                updateIndicators(page)

                when (position) {
                    0 -> {
                        viewPager.setBackgroundColor(color1)
                        updateButtonsVisibility(position)
                    }
                    1 -> {
                        viewPager.setBackgroundColor(color2)
                        updateButtonsVisibility(position)

                    }
                    2 -> {
                        viewPager.setBackgroundColor(color3)
                        updateButtonsVisibility(position)
                    }
                }
            }
        })
    }

    private fun updateIndicators(position: Int) {
        (0 until indicators.size).forEach { i ->
            indicators[i].setBackgroundResource(
                    if (i == position) R.drawable.active_indicator else R.drawable.inactive_indicator
            )
        }
    }

    private fun initColors() {
        color1 = ContextCompat.getColor(this, R.color.light_green_100)
        color2 = ContextCompat.getColor(this, R.color.light_green_200)
        color3 = ContextCompat.getColor(this, R.color.light_green_300)
        colorList = intArrayOf(color1, color2, color3)
    }

    fun updateButtonsVisibility(position: Int) {
        if (position == 2) {
            TransitionManager.beginDelayedTransition(transitionContainer)
            signUpButton.visibility = View.VISIBLE
            startButton.visibility = View.VISIBLE
        } else {
            signUpButton.visibility = View.GONE
            startButton.visibility = View.GONE

        }
    }
}
