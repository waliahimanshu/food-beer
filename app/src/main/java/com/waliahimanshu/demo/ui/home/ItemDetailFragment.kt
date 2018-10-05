package com.waliahimanshu.demo.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.waliahimanshu.demo.ui.R

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [RecipesEntryActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */

class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var mItem: RecipeEntryModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
//                mItem = DummyContent.ITEM_MAP[it.getInt(ARG_ITEM_ID)]
//                activity?.toolbar_layout?.title = mItem?.crsScore
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_item_detail, container, false)

        // Show the dummy content as text in a TextView.
        mItem?.let {
//            rootView.item_detail.text = it.crsDrawDate
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
