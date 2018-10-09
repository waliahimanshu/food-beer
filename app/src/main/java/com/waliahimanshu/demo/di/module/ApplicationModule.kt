package com.waliahimanshu.demo.di.module

import android.app.Application
import android.content.Context
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import com.waliahimanshu.demo.di.scopes.ApplicationContext
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
@Module(includes = [ApplicationModule.Bindings::class])
open class ApplicationModule {

    @Provides
    internal fun provideContext(@ApplicationContext impl: Application): Context {
        return impl
    }


    @Provides
    internal fun providePreferencesHelper(@ApplicationContext context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }

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
    internal fun providesPicasso(@ApplicationContext application: Application): Picasso {
        val picasso = Picasso.get()
        picasso.setIndicatorsEnabled(true)
        picasso.isLoggingEnabled = true
        return picasso
    }

    @Module
    interface Bindings {
//        @Binds
//        @Singleton
//        fun providesFavouritePublish(favouritePublish: FavouritePublish): IFavouritePublisher

//        @Binds
//        @Singleton
//        fun bindContext(@ApplicationContext impl: Application): Context

    }
}
