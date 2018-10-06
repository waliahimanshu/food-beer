package com.waliahimanshu.demo.util

import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesHelper @Inject constructor(context: Context) {

    companion object {
        private const val PREF_DEMO_PACKAGE_NAME = "com.waliahimanshu.demo.preferences"
    }

    private val globalAppPref: SharedPreferences

    init {
        globalAppPref = context.getSharedPreferences(PREF_DEMO_PACKAGE_NAME, Context.MODE_PRIVATE)
    }
}
