package com.waliahimanshu.demo.ui.home

import com.waliahimanshu.demo.data.RecipeRepository
import com.waliahimanshu.demo.data.UserRepository
import com.waliahimanshu.demo.ui.home.mapper.RecipeEntryMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class RecipesFragmentPresenter @Inject constructor(private val mainView: RecipesFragmentContract.View,
                                                   private val mapper: RecipeEntryMapper,
                                                   private val recipeRepository: RecipeRepository,
                                                   private val userRepository: UserRepository) :
        RecipesFragmentContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadData() {
        compositeDisposable.add(
                recipeRepository.getAllRecipes()
                        .flatMap { recipesDTO ->
                            userRepository.getProfiles(recipesDTO.size)
                                    .map { profilesDTo
                                        ->
                                        mapper.map(recipesDTO, profilesDTo)
                                    }
                        }
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            mainView.bindData(it)

                        }, {
                            mainView.showError()
                        }))
    }

    override fun onStop() {
        compositeDisposable.clear()
    }
}


