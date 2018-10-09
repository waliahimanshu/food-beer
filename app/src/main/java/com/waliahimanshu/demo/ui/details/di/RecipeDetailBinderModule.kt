package com.waliahimanshu.demo.ui.details.di

import android.view.View
import com.waliahimanshu.demo.ui.details.RecipesDetailsContract
import com.waliahimanshu.demo.ui.details.RecipesDetailsFragment
import com.waliahimanshu.demo.ui.details.RecipesDetailsFragmentPresenter
import com.waliahimanshu.demo.ui.details.RecipesDetailsView
import dagger.Binds
import dagger.Module
import dagger.Provides


/**
 * Module used to provide dependencies at an activity-level.
 */
@Suppress("unused")
@Module(includes = [RecipeDetailBinderModule.Bindings::class])
class RecipeDetailBinderModule {

    @Provides
    internal fun provideAndroidRootView(fragment: RecipesDetailsFragment): View {
        return fragment.view!!
    }

    @Module
    interface Bindings {

        @Binds
        fun provideRecipesDetailView(recipesDetailsView: RecipesDetailsView): RecipesDetailsContract.View

        @Binds
        fun provideRecipesDetailPresenter(recipesDetailsFragmentPresenter: RecipesDetailsFragmentPresenter): RecipesDetailsContract.Presenter
    }
}
