package com.waliahimanshu.demo.util.picasoo

import android.support.annotation.DrawableRes
import android.widget.ImageView

interface ImageLoader {

    fun load(@DrawableRes id: Int, imageView: ImageView)
    fun load(url: String, imageView: ImageView)
}
