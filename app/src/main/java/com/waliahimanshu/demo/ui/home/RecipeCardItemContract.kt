package com.waliahimanshu.demo.ui.home

import android.widget.ImageView
import com.waliahimanshu.demo.util.picasoo.IBitmapHolder

interface RecipeCardItemContract {
    interface Presenter{
        fun bindData(model: Recipes)
        fun onClick(model: Recipes, recipeImage: ImageView)
        fun init()
    }
    interface View {
        fun setProfileAvatar(bitmapHolder: IBitmapHolder)
        fun setRecipeImageUrl(bitmapHolder: IBitmapHolder)
        fun setRecipeShortDesc(string: String)
        fun setProfileName(name: String)
        fun setProfileDate(date: String)
        fun exposeRecipeImage(): ImageView?
        fun setPresenter(recipeCardItemPresenter: RecipeCardItemContract.Presenter)
        fun exposeProfileImage(): ImageView?
        fun setModel(model: Recipes)
    }
}
