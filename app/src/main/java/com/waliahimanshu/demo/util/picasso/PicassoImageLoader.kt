package com.waliahimanshu.demo.util.picasso

import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.waliahimanshu.demo.ui.R
import javax.inject.Inject

class PicassoImageLoader @Inject constructor(private val picasso: Picasso) : ImageLoader {

    override fun load(url: String, imageView: ImageView) {
        picasso.load(url).noFade().into(imageView)
    }

    override fun load(@DrawableRes id: Int, imageView: ImageView?) {
        imageView?.let {
            picasso.load(id).fit().noFade().placeholder(R.drawable.avatar).into(imageView)

        }
    }
}
