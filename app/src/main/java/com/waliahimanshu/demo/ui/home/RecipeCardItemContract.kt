package com.waliahimanshu.demo.ui.home

import android.widget.ImageView
import com.waliahimanshu.demo.util.picasoo.IBitmapHolder

interface RecipeCardItemContract {
    interface Presenter{
        fun bindData(model: RecipeModel)
    }
    interface View {
        fun setProfileAvatar(bitmapHolder: IBitmapHolder)
        fun setRecipeImageUrl(bitmapHolder: IBitmapHolder)
        fun setRecipeShortDesc(string: String)
        fun setProfileName(name: String)
        fun setProfileDate(date: String)
    }

    interface Interaction {
        fun onItemClick(item: RecipeModel, view: ImageView)
    }
}
