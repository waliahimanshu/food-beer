package com.waliahimanshu.demo.ui.home

import android.util.Log
import com.waliahimanshu.demo.util.picasoo.IBitmapHolder
import com.waliahimanshu.demo.util.picasoo.PicassoBitmapTarget
import com.waliahimanshu.demo.util.picasoo.PicassoImageLoader

class RecipeCardItemPresenter(private val itemView: RecipeCardItemView,
                              private val imageLoader: PicassoImageLoader) : RecipeCardItemContract.Presenter {



    override fun bindData(model: RecipeModel) {
        imageLoader.load(model.recipeImageUrl, recipeImageTarget)
        imageLoader.load(model.personModel.profileImageRes, profileImageTarget)

        with(model) {
            itemView.setProfileName(personModel.name)
            itemView.setProfileDate(personModel.date)
            itemView.setRecipeShortDesc(recipeShortDescription)

        }
    }

    private val recipeImageTarget = object : PicassoBitmapTarget() {
        override fun onSuccess(model: IBitmapHolder) {
            itemView.setRecipeImageUrl(model)
        }

        override fun onError(error: Throwable) {
            Log.e("RecipeCardItemPresenter", "error", error)
        }
    }

    private val profileImageTarget = object : PicassoBitmapTarget() {
        override fun onSuccess(model: IBitmapHolder) {
            itemView.setProfileAvatar(model)
        }

        override fun onError(error: Throwable) {
            Log.e("RecipeCardItemPresenter", "error", error)
        }
    }
}
