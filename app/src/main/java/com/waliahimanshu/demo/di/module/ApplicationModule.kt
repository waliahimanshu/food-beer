package com.waliahimanshu.demo.di.module

import android.app.Application
import android.content.Context
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import com.waliahimanshu.demo.di.scopes.ApplicationContext
import com.waliahimanshu.demo.data.GsonWrapper
import com.waliahimanshu.demo.data.RawResourceWrapper
import com.waliahimanshu.demo.data.RecipeRepository
import com.waliahimanshu.demo.ui.details.FavouritePublish
import com.waliahimanshu.demo.ui.details.IFavouritePublisher
import com.waliahimanshu.demo.util.picasso.ImageLoader
import com.waliahimanshu.demo.util.picasso.PicassoImageLoader
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
        fun providesFavouritePublish(favouritePublish: FavouritePublish): IFavouritePublisher


        @Binds
        @Singleton
        fun bindImageLoader(picassoImageLoader: PicassoImageLoader): ImageLoader

        @Binds
        @Singleton
        fun bindContext(@ApplicationContext context: Application): Context

    }
}
