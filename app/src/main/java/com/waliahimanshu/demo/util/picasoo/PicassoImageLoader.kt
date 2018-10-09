package com.waliahimanshu.demo.util.picasoo

import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject

class PicassoImageLoader @Inject constructor(private val picasso: Picasso) : ImageLoader {

    override fun load(url: String, imageView: ImageView) {
        picasso.load(url).into(imageView)
    }

    override fun load(@DrawableRes id: Int, imageView: ImageView) {
        picasso.load(id).into(imageView)
    }
}
