package com.waliahimanshu.demo.ui.home.cardItem

import com.flextrade.jfixture.FixtureAnnotations
import com.flextrade.jfixture.annotations.Fixture
import com.nhaarman.mockitokotlin2.verify
import com.waliahimanshu.demo.ui.home.RecipesFragmentContract
import com.waliahimanshu.demo.ui.home.domain.Recipes
import com.waliahimanshu.demo.util.PreferencesHelper
import com.waliahimanshu.demo.util.picasso.ImageLoader
import com.waliahimanshu.demo.util.picasso.ImageViewWrapper
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RecipeCardItemPresenterTest {

    @Mock
    lateinit var mockView: RecipeCardItemContract.View
    @Mock
    lateinit var mockImageLoader: ImageLoader
    @Mock
    lateinit var mockInteraction: RecipesFragmentContract.Interaction
    @Mock
    lateinit var mockSharedPref: PreferencesHelper

    @Mock
    lateinit var imageWrapper: ImageViewWrapper


    @Fixture
    lateinit var fixtModel: Recipes

    private lateinit var sut: RecipeCardItemPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        FixtureAnnotations.initFixtures(this)
        sut = RecipeCardItemPresenter(mockView, mockImageLoader, mockInteraction, mockSharedPref)
    }


    @Test
    fun init() {
        sut.init()

        verify(mockView).setPresenter(sut)
    }

    @Test
    fun onClick() {
        sut.onClick(fixtModel, imageWrapper)

        verify(mockInteraction).onItemClick(fixtModel, recipeImage = imageWrapper.imageRecipe)
    }

    @Test
    fun bindImages() {
        sut.bindData(fixtModel, imageWrapper)

        verify(mockImageLoader).load(fixtModel.recipeImageUrl, imageWrapper.imageRecipe)
        verify(mockImageLoader).load(fixtModel.personDto.profileImageRes, imageWrapper.imageProfile)
    }

    @Test
    fun bindProfileData() {
        sut.bindData(fixtModel, imageWrapper)

        verify(mockView).setProfileName(fixtModel.personDto.name)
        verify(mockView).setProfileDate(fixtModel.personDto.date)
    }

    @Test
    fun bindRecipeData() {
        sut.bindData(fixtModel, imageWrapper)

        verify(mockView).setRecipeIngredients(fixtModel.recipeIngredients)
        verify(mockView).setModel(fixtModel)
    }

}
