package com.himanshuw.demo.controls

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import himanshuw.com.demo.ui_controls.R

class ViewPagerIndicator : LinearLayout, ViewPager.OnPageChangeListener {

    constructor(context: Context) : super(context) {
        orientation = HORIZONTAL
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        orientation = HORIZONTAL
    }

    constructor(context: Context, attrs: AttributeSet?,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        orientation = HORIZONTAL
    }

    private var itemCount: Int = 0
    fun setUpViewPager(viewPager: ViewPager) {
        if (viewPager.adapter == null) {
            throw IllegalStateException("Adapter can not be null")
        }

        itemCount = viewPager.adapter!!.count

        addIndicatorItems(itemCount)

        viewPager.addOnPageChangeListener(this)
    }

    private fun addIndicatorItems(itemCount: Int) {
        removeAllViews()
        for (i in 1..itemCount) {
            val indicator = LayoutInflater.from(context).inflate(R.layout.indicator_item, this, false)
            addView(indicator)
        }
    }

    override fun onPageScrollStateChanged(p0: Int) {
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }

    override fun onPageSelected(position: Int) {
        for (i in 0 until itemCount) {
            getChildAt(i).setBackgroundResource(
                    if (i == position) R.drawable.circle_shape_on else R.drawable.circle_shape_off
            )
        }
    }
}
