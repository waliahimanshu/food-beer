package com.waliahimanshu.foodbeer.di.module

import com.waliahimanshu.foodbeer.di.scopes.PerActivity
import com.waliahimanshu.foodbeer.ui.details.RecipesDetailsFragment
import com.waliahimanshu.foodbeer.ui.details.di.RecipeDetailBinderModule
import com.waliahimanshu.foodbeer.ui.home.RecipesActivity
import com.waliahimanshu.foodbeer.ui.home.RecipesFragment
import com.waliahimanshu.foodbeer.ui.home.di.RecipeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
interface ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector
    fun bindRecipeActivity(): RecipesActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [(RecipeActivityModule::class)])
    fun bindRecipeFragment(): RecipesFragment

    @PerActivity
    @ContributesAndroidInjector(modules = [(RecipeDetailBinderModule::class)])
    fun bindRecipesDetailsFragment(): RecipesDetailsFragment
}
