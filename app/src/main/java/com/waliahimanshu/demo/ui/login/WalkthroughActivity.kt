package com.waliahimanshu.demo.ui.login

import android.animation.ArgbEvaluator
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.waliahimanshu.demo.ui.R


class WalkthroughActivity : AppCompatActivity() {
    /**
     * The [ViewPager] that will host the section contents.
     */
    private var page = 0

    private lateinit var viewPager: ViewPager
    private lateinit var indicators: Array<ImageView>
    private lateinit var colorList: IntArray

    private var evaluator = ArgbEvaluator()
    private var color1: Int = 0
    private var color2: Int = 0
    private var color3: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        setUpViewPager()
        initColors()

        indicators = arrayOf(findViewById(R.id.intro_indicator_0),
                findViewById(R.id.intro_indicator_1),
                findViewById(R.id.intro_indicator_2))

        indicators.let {
            it[0].setBackgroundResource(R.drawable.active_indicator)
        }
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
                    0 -> viewPager.setBackgroundColor(color1)
                    1 -> viewPager.setBackgroundColor(color2)
                    2 -> viewPager.setBackgroundColor(color3)
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
}
