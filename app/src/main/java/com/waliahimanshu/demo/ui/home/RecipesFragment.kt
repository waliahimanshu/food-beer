package com.waliahimanshu.demo.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.ui.details.RecipesDetailsFragment
import javax.inject.Inject

const val EXTRA_RECIPE_ITEM = "animal_image_url"
const val EXTRA_RECIPE_IMAGE_TRANSITION_NAME = "animal_image_transition_name"

class RecipesFragment : Fragment(), RecipesEntryContract.View, RecipeEntryAdapter.OnItemClickListener {
    private val TAG = RecipesFragment::class.java.simpleName

    companion object {
        fun newInstance(): RecipesFragment {
            return RecipesFragment()
        }

    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecipeEntryAdapter

    @Inject
    lateinit var recipesEntryPresenter: RecipesEntryContract.Presenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(requireContext())
        val myDataSet = DataSource.get()
        viewAdapter = RecipeEntryAdapter(myDataSet, onItemClickListener = this)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onItemClick(item: RecipeEntryModel, sharedImageView: ImageView) {

        val detailFragment = RecipesDetailsFragment.newInstance(item, ViewCompat.getTransitionName(sharedImageView)!!)

        requireActivity().supportFragmentManager
                ?.beginTransaction()
                ?.addSharedElement(sharedImageView, ViewCompat.getTransitionName(sharedImageView)!!)
                ?.addToBackStack(TAG)
                ?.replace(R.id.recipes_root, detailFragment)
                ?.commit()

    }


    override fun showProgressBar(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showEmptyState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPresenter(presenter: RecipesEntryContract.Presenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

