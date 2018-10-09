package com.waliahimanshu.demo.di.module

import com.waliahimanshu.demo.di.scopes.PerActivity
import com.waliahimanshu.demo.ui.details.RecipesDetailsFragment
import com.waliahimanshu.demo.ui.details.di.RecipeDetailBinderModule
import com.waliahimanshu.demo.ui.home.RecipesActivity
import com.waliahimanshu.demo.ui.home.RecipesFragment
import com.waliahimanshu.demo.ui.home.di.RecipeActivityModule
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
