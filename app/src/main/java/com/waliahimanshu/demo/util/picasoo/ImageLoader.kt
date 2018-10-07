package com.waliahimanshu.demo.util.picasoo

import android.support.annotation.DrawableRes
import com.squareup.picasso.Target

interface ImageLoader {

    fun preload(url: String)
    fun load(url: String, target: Target)
    fun load(@DrawableRes id: Int, target: Target)
    fun cancel(target: Target)
}
