package com.waliahimanshu.demo.ui.home.di

import com.waliahimanshu.demo.di.scopes.PerActivity
import com.waliahimanshu.demo.network.RecipeRepository
import com.waliahimanshu.demo.network.UserRepository
import com.waliahimanshu.demo.ui.home.RecipeEntryMapper
import com.waliahimanshu.demo.ui.home.RecipesFragment
import com.waliahimanshu.demo.ui.home.RecipesFragmentContract
import com.waliahimanshu.demo.ui.home.RecipesFragmentPresenter
import dagger.Module
import dagger.Provides


/**
 * Module used to provide dependencies at an activity-level.
 */
@Suppress("unused")
@Module
class RecipeActivityModule {

    @PerActivity
    @Provides
    internal fun provideHomeView(recipesFragment: RecipesFragment): RecipesFragmentContract.View {
        return recipesFragment
    }

    @PerActivity
    @Provides
    internal fun provideExpressEntryPresenter(mainView: RecipesFragmentContract.View, recipeRepository: RecipeRepository):
            RecipesFragmentContract.Presenter {
        return RecipesFragmentPresenter(mainView, RecipeEntryMapper(), recipeRepository, UserRepository())
    }
}
