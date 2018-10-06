package com.waliahimanshu.demo.di.module

import com.waliahimanshu.demo.di.scopes.PerActivity
import com.waliahimanshu.demo.ui.home.RecipesEntryContract
import com.waliahimanshu.demo.ui.home.RecipesEntryPresenter
import com.waliahimanshu.demo.ui.home.RecipesFragment
import com.waliahimanshu.demo.ui.home.RecipeEntryMapper
import dagger.Module
import dagger.Provides


/**
 * Module used to provide dependencies at an activity-level.
 */
@Suppress("unused")
@Module
class RecipeEntryActivityModule {

    @PerActivity
    @Provides
    internal fun provideHomeView(recipesFragment: RecipesFragment): RecipesEntryContract.View {
        return recipesFragment
    }

    @PerActivity
    @Provides
    internal fun provideExpressEntryPresenter(mainView: RecipesEntryContract.View): RecipesEntryContract.Presenter {
        return RecipesEntryPresenter(mainView, RecipeEntryMapper())
    }
}
