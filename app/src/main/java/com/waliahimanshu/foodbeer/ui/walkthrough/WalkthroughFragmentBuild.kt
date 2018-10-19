package com.waliahimanshu.foodbeer.ui.walkthrough

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.waliahimanshu.foodbeer.ui.R

class WalkthroughFragmentBuild : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_walkthrough_build, container, false)
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): WalkthroughFragmentBuild {
            val fragment = WalkthroughFragmentBuild()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
