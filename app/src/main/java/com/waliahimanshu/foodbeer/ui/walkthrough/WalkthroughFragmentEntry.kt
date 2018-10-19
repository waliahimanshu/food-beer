package com.waliahimanshu.foodbeer.ui.walkthrough

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.himanshuw.foodbeer.controls.AnimationHelper
import com.waliahimanshu.foodbeer.ui.R
import com.waliahimanshu.foodbeer.ui.home.RecipesActivity
import kotlinx.android.synthetic.main.fragment_walkthrough_entry.*

class WalkthroughFragmentEntry : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_walkthrough_entry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.slideUpFromBottom(button_sign_up)
        AnimationHelper.slideUpFromBottom(button_start)

        button_start.setOnClickListener {
            startActivity(RecipesActivity.getLaunchIntent(requireContext()))
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): WalkthroughFragmentEntry {
            val fragment = WalkthroughFragmentEntry()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
