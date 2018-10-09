package com.waliahimanshu.demo.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GestureDetectorCompat
import android.transition.Slide
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


class RecipesDetailsFragment : Fragment(),   View.OnTouchListener {


    private lateinit var detector: GestureDetectorCompat

    override fun onTouch(v: View?, motionEvent: MotionEvent): Boolean {
        return detector.onTouchEvent(motionEvent)

    }

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

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState).also {

        detector = GestureDetectorCompat(context, object : GestureDetector.OnGestureListener {
            override fun onShowPress(e: MotionEvent?) {
            }

            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                return true
            }

            override fun onDown(e: MotionEvent?): Boolean {

                return true
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
                return false
            }

            override fun onLongPress(e: MotionEvent?) {
            }

            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {

                if (e2.y > e1.y) {
                    // direction up
                    activity?.supportFragmentManager?.popBackStack()
                } else {
                    // direction down
                    activity?.supportFragmentManager?.popBackStack()

                }
                return true

            }
        })
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

        val imageView = view.findViewById<ImageView>(R.id.detail_recipe_image)
        imageView.setOnTouchListener(this)

        val ingredients = view.findViewById<TextView>(R.id.details_item_ingredients)

        val slide = Slide(Gravity.BOTTOM)
        slide.interpolator = AnimationUtils.loadInterpolator(requireContext(), android.R.interpolator.linear_out_slow_in)
        slide.duration = 10
        slide.addTarget(ingredients)
        ingredients.text = model?.recipeIngredients
        enterTransition = slide

    }
}
