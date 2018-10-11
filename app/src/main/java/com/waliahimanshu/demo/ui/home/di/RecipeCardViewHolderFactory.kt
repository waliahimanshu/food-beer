package com.waliahimanshu.demo.ui.home.di

import android.view.View
import com.waliahimanshu.demo.ui.home.cardItem.RecipeCardItemContract
import com.waliahimanshu.demo.ui.home.cardItem.RecipeCardItemPresenter
import com.waliahimanshu.demo.ui.home.cardItem.RecipeCardItemView
import com.waliahimanshu.demo.ui.home.cardItem.RecipeCardViewHolder
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [RecipeCardViewHolderFactory.ViewHolderBindings::class])
interface RecipeCardViewHolderFactory {

    fun createViewHolder(): RecipeCardViewHolder

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun cardView(cardView: View): RecipeCardViewHolderFactory.Builder

        fun build(): RecipeCardViewHolderFactory
    }

    @Module
    interface ViewHolderBindings {

        @Binds
        fun bindRecipeCardItemPresenterContract(presenter: RecipeCardItemPresenter): RecipeCardItemContract.Presenter

        @Binds
        fun bindRecipeCardItemViewContract(view: RecipeCardItemView): RecipeCardItemContract.View
    }
}
