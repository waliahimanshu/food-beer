package com.waliahimanshu.demo.ui.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.waliahimanshu.demo.ui.R.id.*
import com.waliahimanshu.demo.util.picasoo.IBitmapHolder

class RecipeCardItemView(private val view: View) : RecipeCardItemContract.View {

    override fun setProfileAvatar(bitmapHolder: IBitmapHolder) =
            view.findViewById<ImageView>(profile_avatar).setImageBitmap(bitmapHolder.bitmap)

    override fun setRecipeImageUrl(bitmapHolder: IBitmapHolder) =
            view.findViewById<ImageView>(profile_recipe_image).setImageBitmap(bitmapHolder.bitmap)

    override fun setRecipeShortDesc(string: String) {
        view.findViewById<TextView>(recipe_short_discription).text = string
    }

    override fun setProfileName(name: String) {
        view.findViewById<TextView>(profile_tile).text = name
    }

    override fun setProfileDate(date: String) {
        view.findViewById<TextView>(profile_subtitle_text).text = date
    }
}

