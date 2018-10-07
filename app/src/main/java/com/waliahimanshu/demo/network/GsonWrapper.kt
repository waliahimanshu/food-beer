package com.waliahimanshu.demo.network

import com.google.gson.Gson
import com.google.gson.stream.MalformedJsonException
import java.io.Reader
import javax.inject.Inject


class GsonWrapper @Inject constructor(private val gson: Gson) {

    fun toJson(src: Any?): String? {
        return gson.toJson(src)
    }

    fun <T> fromJson(reader: Reader, classOfT: Class<T>): T? {
        try {

            return gson.fromJson(reader, classOfT)
        } catch (ex: MalformedJsonException) {

        }
        return null
    }
}
