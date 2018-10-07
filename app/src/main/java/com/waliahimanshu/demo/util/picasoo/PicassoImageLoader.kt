package com.waliahimanshu.demo.util.picasoo

import android.support.annotation.DrawableRes
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import javax.inject.Inject

class PicassoImageLoader @Inject constructor(private val picasso: Picasso) : ImageLoader {

    override fun preload(url: String) {
        picasso.load(url).fetch()
    }

    override fun load(url: String, target: Target) {
        picasso.load(url).into(target)
    }

    override fun load(@DrawableRes id: Int, target: Target) {
        picasso.load(id).into(target)
    }

    override fun cancel(target: Target) {
        picasso.cancelRequest(target)
    }
}
