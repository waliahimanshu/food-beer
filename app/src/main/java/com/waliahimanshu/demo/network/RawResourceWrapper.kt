package com.waliahimanshu.demo.network

import android.content.Context
import android.support.annotation.RawRes
import com.waliahimanshu.demo.di.scopes.ApplicationContext
import java.io.InputStreamReader
import java.io.Reader
import javax.inject.Inject

class RawResourceWrapper @Inject constructor(@ApplicationContext private val context: Context) {

    fun openRawResource(@RawRes id: Int): Reader {
         return InputStreamReader(context.resources.openRawResource(id))
    }
}
