package com.waliahimanshu.demo.ui.login

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

private const val totalSections = 3

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the on-boarding screens.
 */
class SectionsPagerAdapter constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(pos: Int): Fragment {
        return when (pos) {
            0 -> WalkthroughFragmentInspire.newInstance(0)
            1 -> WalkthroughFragmentBuild.newInstance(1)
            else -> WalkthroughFragmentEntry.newInstance(2)
        }
    }

    override fun getCount(): Int {
        return totalSections
    }
}
