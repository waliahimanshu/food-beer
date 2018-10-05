package com.waliahimanshu.demo.di.module

import android.app.Application
import android.content.Context
import com.waliahimanshu.demo.di.scopes.PerApplication
import com.waliahimanshu.demo.util.PreferencesHelper
import dagger.Module
import dagger.Provides

/**
 * Module used to provide dependencies at an application-level.
 */
@Suppress("unused")
@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }
}
