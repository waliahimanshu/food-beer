package com.waliahimanshu.demo.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.waliahimanshu.demo.di.scopes.ApplicationContext
import com.waliahimanshu.demo.di.scopes.PerApplication
import com.waliahimanshu.demo.network.GsonWrapper
import com.waliahimanshu.demo.network.RawResourceWrapper
import com.waliahimanshu.demo.network.RecipeRepository
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
    fun provideContext(@ApplicationContext application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(@ApplicationContext context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }

    @Provides
    @PerApplication
    internal fun providesResourceWrapper(@ApplicationContext context: Context): RawResourceWrapper {
        return RawResourceWrapper(context)
    }

    @Provides
    @PerApplication
    internal fun providesGsonWrapper(@ApplicationContext context: Context): GsonWrapper {
        return GsonWrapper(Gson())
    }

    @Provides
    @PerApplication
    internal fun providesRawLoader(rawResourceWrapper: RawResourceWrapper, gsonWrapper: GsonWrapper): RecipeRepository {
        return RecipeRepository(rawResourceWrapper, gsonWrapper)
    }

    @Provides
    @PerApplication
    internal fun providesPicasso(): Picasso {
        return Picasso.get()
    }
}
