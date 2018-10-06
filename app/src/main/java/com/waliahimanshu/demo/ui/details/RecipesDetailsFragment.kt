package com.waliahimanshu.demo.ui.details

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.ui.home.EXTRA_RECIPE_IMAGE_TRANSITION_NAME
import com.waliahimanshu.demo.ui.home.EXTRA_RECIPE_ITEM
import com.waliahimanshu.demo.ui.home.RecipeEntryModel


class RecipesDetailsFragment : Fragment() {

    companion object {
        fun newInstance(itemModel: RecipeEntryModel, transitionName: String): RecipesDetailsFragment {
            val bundle = Bundle()
            bundle.putParcelable(EXTRA_RECIPE_ITEM, itemModel)
            bundle.putString(EXTRA_RECIPE_IMAGE_TRANSITION_NAME, transitionName)
            val recipesDetailsFragment = RecipesDetailsFragment()
            recipesDetailsFragment.arguments = bundle
            return recipesDetailsFragment
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState).also {
        postponeEnterTransition()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recipe_item_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        fab {
//            Snackbar.make(it, "Replace with your own detail action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        val model = arguments?.getParcelable<RecipeEntryModel>(EXTRA_RECIPE_ITEM)

        val imageView = view.findViewById<ImageView>(R.id.image_header)
        val textView = view.findViewById<TextView>(R.id.item_detail_text)

        textView.text = model!!.recipeShortDescription

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val imageTransitionName = arguments?.getString(EXTRA_RECIPE_IMAGE_TRANSITION_NAME)
            imageView.transitionName = imageTransitionName
        }

        Picasso.get()
                .load(model.recipeImageUrl)
                .noFade()
                .into(imageView, object : Callback {
                    override fun onSuccess() {
                        startPostponedEnterTransition()
                    }

                    override fun onError(exception: Exception) {
                        startPostponedEnterTransition()
                    }
                })
    }

}
