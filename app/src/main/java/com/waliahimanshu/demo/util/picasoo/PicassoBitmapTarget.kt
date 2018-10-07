package com.waliahimanshu.demo.util.picasoo

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

abstract class PicassoBitmapTarget : Target {

    abstract fun onSuccess(model: IBitmapHolder)
    abstract fun onError(error: Throwable)

    override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
        onSuccess(BitmapHolder(bitmap))
    }

    override fun onBitmapFailed(e: Exception, errorDrawable: Drawable?) {
        onError(Throwable(e))
    }

    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

    }
}
