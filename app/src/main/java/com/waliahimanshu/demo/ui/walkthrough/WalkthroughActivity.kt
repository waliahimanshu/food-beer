package com.waliahimanshu.demo.ui.walkthrough

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.waliahimanshu.demo.ui.R
import kotlinx.android.synthetic.main.activity_walkthrough.*


class WalkthroughActivity : AppCompatActivity() {
    /**
     * The [ViewPager] that will host the section contents.
     */

    private lateinit var viewPager: ViewPager
    private lateinit var indicators: Array<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        setUpViewPager()

        indicators = arrayOf(findViewById(R.id.intro_indicator_0),
                findViewById(R.id.intro_indicator_1),
                findViewById(R.id.intro_indicator_2))

        indicators.let {
            it[0].setBackgroundResource(R.drawable.circle_shape_on)
        }
    }

    private fun setUpViewPager() {

        viewPager = findViewById(R.id.sections_view_pager)
        viewPager.adapter = SectionsPagerAdapter(supportFragmentManager)
        view_pager_indicator.setUpViewPager(viewPager)
    }
}
