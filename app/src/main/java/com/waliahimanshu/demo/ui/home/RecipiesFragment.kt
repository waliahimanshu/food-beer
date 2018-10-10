package com.waliahimanshu.demo.ui.home

import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.ui.details.RecipesDetailActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

const val EXTRA_RECIPE_ITEM = "animal_image_url"
const val EXTRA_RECIPE_IMAGE_TRANSITION_NAME = "animal_image_transition_name"

class RecipesFragment : Fragment(), RecipesFragmentContract.View, RecipesFragmentContract.Interaction {

    companion object {
        fun newInstance(): RecipesFragment {
            return RecipesFragment()
        }
    }

    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var adapter: RecipesAdapter

    @Inject
    lateinit var recipesFragmentPresenter: RecipesFragmentContract.Presenter

    override fun onItemClick(selectedModel: Recipes) {
        val toBundle = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity()).toBundle()
        val launchIntent = RecipesDetailActivity.getLaunchIntent(requireContext(), selectedModel, "")

        startActivity(launchIntent, toBundle)

        /* requireActivity().supportFragmentManager
                 ?.beginTransaction()
                 ?.addSharedElement(recipeImage, ViewCompat.getTransitionName(recipeImage)!!)
                 ?.addToBackStack(TAG)
                 ?.add(R.id.recipes_root,  RecipesDetailsFragment.newInstance(recipeModel, ViewCompat.getTransitionName(recipeImage)!!))
                 ?.commit()*/
    }

    override fun onStart() {
        super.onStart()
        recipesFragmentPresenter.loadData()
    }

    override fun onStop() {
        super.onStop()
        recipesFragmentPresenter.onStop()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

    }

    override fun showError() {
        Toast.makeText(context, "Could not load recipes", Toast.LENGTH_LONG).show()
    }

    override fun bindData(recipes: List<Recipes>) {
        adapter.bindData(recipes)
    }
}

