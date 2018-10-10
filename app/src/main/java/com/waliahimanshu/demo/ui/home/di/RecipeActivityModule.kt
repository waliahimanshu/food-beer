package com.waliahimanshu.demo.ui.home.di

import com.waliahimanshu.demo.di.scopes.PerActivity
import com.waliahimanshu.demo.network.RecipeRepository
import com.waliahimanshu.demo.network.UserRepository
import com.waliahimanshu.demo.ui.home.RecipeEntryMapper
import com.waliahimanshu.demo.ui.home.RecipesFragment
import com.waliahimanshu.demo.ui.home.RecipesFragmentContract
import com.waliahimanshu.demo.ui.home.RecipesFragmentPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides


/**
 * Module used to provide dependencies at an activity-level.
 */
@Suppress("unused")
@Module(
        includes = [RecipeActivityModule.Bindings::class],
        subcomponents = [RecipeCardViewHolderFactory::class])

class RecipeActivityModule {

    @PerActivity
    @Provides
    internal fun provideRecipesFragmentView(recipesFragment: RecipesFragment): RecipesFragmentContract.View {
        return recipesFragment
    }

    @PerActivity
    @Provides
    internal fun provideRecipesFragmentPresenter(mainView: RecipesFragmentContract.View, recipeRepository: RecipeRepository):
            RecipesFragmentContract.Presenter {
        return RecipesFragmentPresenter(mainView, RecipeEntryMapper(), recipeRepository, UserRepository())
    }

    @Module
    interface Bindings {

        @Binds
        fun provideRecipesDetailView(recipesFragment: RecipesFragment): RecipesFragmentContract.Interaction

    }
}

