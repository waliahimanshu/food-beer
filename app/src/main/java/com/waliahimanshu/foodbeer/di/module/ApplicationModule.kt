package com.waliahimanshu.foodbeer.di.module

import android.app.Application
import android.content.Context
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import com.waliahimanshu.foodbeer.data.GsonWrapper
import com.waliahimanshu.foodbeer.data.RawResourceWrapper
import com.waliahimanshu.foodbeer.data.RecipeRepository
import com.waliahimanshu.foodbeer.di.scopes.ApplicationContext
import com.waliahimanshu.foodbeer.util.IScheduler
import com.waliahimanshu.foodbeer.util.PreferencesHelper
import com.waliahimanshu.foodbeer.util.Scheduler
import com.waliahimanshu.foodbeer.util.picasso.ImageLoader
import com.waliahimanshu.foodbeer.util.picasso.PicassoImageLoader
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Module used to provide dependencies for application-level.
 */

@Suppress("unused")
@Module(includes = [ApplicationModule.Bindings::class])
open class ApplicationModule {

    @Provides
    internal fun providesResourceWrapper(@ApplicationContext context: Context): RawResourceWrapper {
        return RawResourceWrapper(context)
    }

    @Provides
    internal fun providesGsonWrapper(): GsonWrapper {
        val gson = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().serializeNulls().create()
        return GsonWrapper(gson)
    }

    @Provides
    internal fun providesRawLoader(rawResourceWrapper: RawResourceWrapper, gsonWrapper: GsonWrapper): RecipeRepository {
        return RecipeRepository(rawResourceWrapper, gsonWrapper)
    }


    @Provides
    @Singleton
    internal fun providesPreferencesHelper(@ApplicationContext applicationContext: Context): PreferencesHelper {
        return PreferencesHelper(applicationContext)
    }


    @Provides
    @Singleton
    internal fun providesPicasso(@ApplicationContext context: Context): Picasso {
        return Picasso
                .Builder(context)
                .indicatorsEnabled(true)
                .loggingEnabled(true)
                .build()
    }


    @Module
    interface Bindings {


        @Binds
        @Singleton
        fun bindImageLoader(picassoImageLoader: PicassoImageLoader): ImageLoader

        @Binds
        @Singleton
        fun bindContext(@ApplicationContext context: Application): Context

        @Binds
        @Singleton
        fun bindScheduler(scheduler: Scheduler): IScheduler
    }
}
