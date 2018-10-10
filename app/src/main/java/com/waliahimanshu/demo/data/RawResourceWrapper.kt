package com.waliahimanshu.demo.data

import android.content.Context
import android.support.annotation.RawRes
import com.waliahimanshu.demo.di.scopes.ApplicationContext
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import javax.inject.Inject

class RawResourceWrapper @Inject constructor(@ApplicationContext private val context: Context) {

    fun openRawResource(@RawRes id: Int): InputStreamReader {
        try {
            return InputStreamReader(context.resources.openRawResource(id))
        } catch (ex : UnsupportedEncodingException) {
            throw IllegalArgumentException("Could not open resource file with id : $id", ex )
        }
    }
}
