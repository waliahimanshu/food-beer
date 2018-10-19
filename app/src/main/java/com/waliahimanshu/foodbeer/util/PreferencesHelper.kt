package com.waliahimanshu.foodbeer.util

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesHelper @Inject constructor(context: Context) {

    companion object {
        private const val PREF_DEMO_PACKAGE_NAME = "com.waliahimanshu.demo.preferences"
    }

    private val globalAppPref: SharedPreferences

    init {
        globalAppPref = context.getSharedPreferences(PREF_DEMO_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    fun getValueBy(key: String): Boolean {
        return globalAppPref.getBoolean(key, false)
    }

    fun save(key: String, value: Boolean) {
        globalAppPref.edit().putBoolean(key, value).apply()
    }

    fun remove(key: String) {
        globalAppPref.edit().remove(key).apply()
    }
}
