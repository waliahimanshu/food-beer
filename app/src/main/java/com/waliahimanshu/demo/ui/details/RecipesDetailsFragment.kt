package com.waliahimanshu.demo.ui.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.ui.home.EXTRA_RECIPE_ITEM
import com.waliahimanshu.demo.ui.home.domain.Recipes
import com.waliahimanshu.demo.util.picasso.ImageViewWrapper
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.recipe_item_detail.*
import javax.inject.Inject


class RecipesDetailsFragment : Fragment(), RecipesDetailsContract.Interaction {
    companion object {
        fun newInstance(itemModel: Recipes): RecipesDetailsFragment {
            val bundle = Bundle()
            bundle.putParcelable(EXTRA_RECIPE_ITEM, itemModel)
            val recipesDetailsFragment = RecipesDetailsFragment()
            recipesDetailsFragment.arguments = bundle
            return recipesDetailsFragment
        }
    }

    @Inject
    lateinit var detailsPresenter: RecipesDetailsContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recipe_item_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AndroidSupportInjection.inject(this)

        val model = arguments?.getParcelable<Recipes>(EXTRA_RECIPE_ITEM)
        val twoPane = resources.getInteger(R.integer.column)

        detailsPresenter.bindData(model!!, ImageViewWrapper(detail_recipe_image, details_profile_image), twoPane)

    }

    override fun onCollapseClick() {
        requireActivity().finishAfterTransition()
    }
}
