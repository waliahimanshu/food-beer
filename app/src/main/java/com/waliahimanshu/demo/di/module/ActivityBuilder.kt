package com.waliahimanshu.demo.di.module

import com.waliahimanshu.demo.di.scopes.PerActivity
import com.waliahimanshu.demo.ui.home.RecipesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
interface ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector(modules = [(RecipeEntryActivityModule::class)])
    fun bindMainActivity(): RecipesActivity

//    @PerActivity
//    @ContributesAndroidInjector(modules = [])
//    fun bindWalkthroughActivity(): WalkthroughActivity

//    @PerActivity
//    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
//    fun bindLoginActivity() : LoginActivity
}
