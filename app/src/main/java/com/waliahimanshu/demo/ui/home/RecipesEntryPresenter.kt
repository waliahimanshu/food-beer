package com.waliahimanshu.demo.ui.home

import com.waliahimanshu.demo.network.DataSource
import com.waliahimanshu.demo.network.RecipeRepository
import javax.inject.Inject


class RecipesEntryPresenter @Inject constructor(private val mainView: RecipesFragmentContract.View,
                                                private val mapper: RecipeEntryMapper, private val recipeRepository: RecipeRepository) : RecipesFragmentContract.Presenter {

    override fun loadData(id: Int) {
        val allRecipes = recipeRepository.getAllRecipes(id)
        val profiles = DataSource.get(allRecipes.size)
        val map = mapper.map(allRecipes, profiles)

        mainView.bindData(map)
    }



    override fun onDestroy() {
    }
}
