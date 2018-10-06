package com.waliahimanshu.demo.ui.login

import android.animation.ArgbEvaluator
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.ui.home.RecipesActivity

class WalkthroughActivity : AppCompatActivity() {
    /**
     * The [ViewPager] that will host the section contents.
     */
    private var viewPager: ViewPager? = null
    private var evaluator = ArgbEvaluator()
    private var page = 0
    private var indicators: Array<ImageView>? = null
    private var signUpButton: Button? = null
    private var startButton: Button? = null
    private lateinit var colorList: IntArray
    private var color1: Int = 0
    private var color2: Int = 0
    private var color3: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        signUpButton = findViewById(R.id.button_1)
        startButton = findViewById(R.id.button_2)

        // Set up the ViewPager with the sections adapter.
        viewPager = findViewById(R.id.sections_view_pager)
        viewPager?.adapter = SectionsPagerAdapter(supportFragmentManager)


        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixel: Int) {
                val colorUpdate = evaluator.evaluate(
                        positionOffset,
                        colorList[position],
                        colorList[if (position == 2) position else position + 1]) as Int
                viewPager?.setBackgroundColor(colorUpdate)
            }

            override fun onPageSelected(position: Int) {
                page = position
                updateIndicators(page)

                when (position) {
                    0 -> viewPager?.setBackgroundColor(color1)
                    1 -> viewPager?.setBackgroundColor(color2)
                    2 -> viewPager?.setBackgroundColor(color3)
                }
            }
        })

        initColors()
        initIndicators()

        indicators?.let {
            it[0].setBackgroundResource(R.drawable.active_indicator)
        }

        startButton?.setOnClickListener {
            startActivity(RecipesActivity.getLaunchIntent(this))
        }

        signUpButton?.setOnClickListener {
        }

        // Hide the status bar.
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.decorView.systemUiVisibility = uiOptions
    }

    private fun updateIndicators(position: Int) {
        (0 until indicators?.size as Int).forEach { i ->
            indicators?.get(i)?.setBackgroundResource(
                    if (i == position) R.drawable.active_indicator else R.drawable.inactive_indicator
            )
        }
    }

    private fun initColors() {
        color1 = ContextCompat.getColor(this, R.color.white)
        color2 = ContextCompat.getColor(this, R.color.white)
        color3 = ContextCompat.getColor(this, R.color.white)
        colorList = intArrayOf(color1, color2, color3)
    }

    private fun initIndicators() {
        val indicator1 = findViewById<ImageView>(R.id.intro_indicator_0)
        val indicator2 = findViewById<ImageView>(R.id.intro_indicator_1)
        val indicator3 = findViewById<ImageView>(R.id.intro_indicator_2)

        indicators = arrayOf(indicator1, indicator2, indicator3)
    }
}
