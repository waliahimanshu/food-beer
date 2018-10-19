package com.waliahimanshu.foodbeer.ui.home

import android.support.annotation.VisibleForTesting
import com.waliahimanshu.foodbeer.data.RecipeRepository
import com.waliahimanshu.foodbeer.data.UserRepository
import com.waliahimanshu.foodbeer.ui.home.domain.Recipes
import com.waliahimanshu.foodbeer.ui.home.dto.PersonDto
import com.waliahimanshu.foodbeer.ui.home.dto.RecipesDTO
import com.waliahimanshu.foodbeer.ui.home.mapper.RecipeEntryMapper
import com.waliahimanshu.foodbeer.util.IScheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import javax.inject.Inject


class RecipesFragmentPresenter @Inject constructor(private val mainView: RecipesFragmentContract.View,
                                                   private val mapper: RecipeEntryMapper,
                                                   private val recipeRepository: RecipeRepository,
                                                   private val userRepository: UserRepository,
                                                   private val scheduler: IScheduler) :
        RecipesFragmentContract.Presenter {

    @VisibleForTesting
    var compositeDisposable = CompositeDisposable()

    override fun loadData() {
        compositeDisposable.add(
                Single.zip(
                        recipeRepository.getAllRecipes()
                                .subscribeOn(scheduler.background()),
                        userRepository.getProfiles()
                                .subscribeOn(scheduler.background()),
                        BiFunction<List<RecipesDTO>, List<PersonDto>, List<Recipes>>(mapper::map))
                        .observeOn(scheduler.main())
                        .subscribeOn(scheduler.background())
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


