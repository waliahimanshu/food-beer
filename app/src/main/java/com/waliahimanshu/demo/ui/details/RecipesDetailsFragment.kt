package com.waliahimanshu.demo.ui.details

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.ui.home.EXTRA_RECIPE_IMAGE_TRANSITION_NAME
import com.waliahimanshu.demo.ui.home.EXTRA_RECIPE_ITEM
import com.waliahimanshu.demo.ui.home.Recipes
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class RecipesDetailsFragment : Fragment() {

    companion object {
        fun newInstance(itemModel: Recipes, transitionName: String): RecipesDetailsFragment {
            val bundle = Bundle()
            bundle.putParcelable(EXTRA_RECIPE_ITEM, itemModel)
            bundle.putString(EXTRA_RECIPE_IMAGE_TRANSITION_NAME, transitionName)
            val recipesDetailsFragment = RecipesDetailsFragment()
            recipesDetailsFragment.arguments = bundle
            return recipesDetailsFragment
        }
    }

    @Inject
    lateinit var detailsPresenter: RecipesDetailsContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recipe_item_detail, container, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AndroidSupportInjection.inject(this)
        val model = arguments?.getParcelable<Recipes>(EXTRA_RECIPE_ITEM)
        detailsPresenter.bindData(model!!)


        val imageView: ImageView = view.findViewById(R.id.detail_recipe_image)
        val navClose: ImageView = view.findViewById(R.id.nav_close_button)

        imageView.setOnTouchListener(object: VerticalSwipeTouchListener(requireContext()) {
            override fun onSwipeDown() {
                requireActivity().finishAfterTransition()
            }

            override fun onSwipeUp() {
                requireActivity().finishAfterTransition()
            }
        })

        navClose.setOnClickListener {
            requireActivity().finishAfterTransition()
        }

        val ingredients: TextView = view.findViewById(R.id.details_item_ingredients)

        val slide = Slide(Gravity.BOTTOM)
        slide.interpolator = AnimationUtils.loadInterpolator(requireContext(), android.R.interpolator.linear_out_slow_in)
        slide.addTarget(ingredients)
        enterTransition = slide

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // Respond to the action bar's Up/Home button
            android.R.id.home -> {
                activity?.supportFinishAfterTransition()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
