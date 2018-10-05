package com.waliahimanshu.demo.di.module

import com.waliahimanshu.demo.di.scopes.PerActivity
import com.waliahimanshu.demo.ui.home.RecpieEntryMapper
import com.waliahimanshu.demo.ui.home.RecipesEntryActivity
import com.waliahimanshu.demo.ui.home.RecipesEntryContract
import com.waliahimanshu.demo.ui.home.RecipesEntryPresenter
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
    internal fun provideHomeView(recipesEntryActivity: RecipesEntryActivity): RecipesEntryContract.View {
        return recipesEntryActivity
    }

    @PerActivity
    @Provides
    internal fun provideExpressEntryPresenter(mainView: RecipesEntryContract.View): RecipesEntryContract.Presenter {
        return RecipesEntryPresenter(mainView, RecpieEntryMapper())
    }
}
