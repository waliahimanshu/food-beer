package com.waliahimanshu.demo.ui.details

import com.flextrade.jfixture.FixtureAnnotations
import com.flextrade.jfixture.annotations.Fixture
import com.flextrade.jfixture.annotations.Range
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.waliahimanshu.demo.ui.home.domain.Recipes
import com.waliahimanshu.demo.util.PreferencesHelper
import com.waliahimanshu.demo.util.picasso.ImageLoader
import com.waliahimanshu.demo.util.picasso.ImageViewWrapper
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RecipesDetailsFragmentPresenterTest {

    @Mock
    lateinit var mockView: RecipesDetailsContract.View
    @Mock
    lateinit var mockImageLoader: ImageLoader
    @Mock
    lateinit var mockInteraction: RecipesDetailsContract.Interaction
    @Mock
    lateinit var mockSharedPref: PreferencesHelper

    @Mock
    lateinit var imageWrapper: ImageViewWrapper

    @Fixture
    lateinit var fixtModel: Recipes

    @Fixture
    var fixtState: Boolean = false

    @Fixture
    lateinit var fixtRecipeId: String

    private lateinit var sut: RecipesDetailsFragmentPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        FixtureAnnotations.initFixtures(this)
        sut = RecipesDetailsFragmentPresenter(mockView, mockImageLoader, mockInteraction, mockSharedPref)
    }


    @Fixture
    @Range(min = 0, max = 2)
    var twoPane: Int = 0

    @Test
    fun bindImages() {
        sut.bindData(fixtModel, imageWrapper, twoPane)

        verify(mockImageLoader).load(fixtModel.recipeImageUrl, imageWrapper.imageRecipe)
        verify(mockImageLoader).load(fixtModel.personDto.profileImageRes, imageWrapper.imageProfile)
    }

    @Test
    fun bindProfileData() {
        sut.bindData(fixtModel, imageWrapper, twoPane)

        verify(mockView).setProfileName(fixtModel.personDto.name)
        verify(mockView).setProfileDate(fixtModel.personDto.date)
    }

    @Test
    fun bindRecipeData() {
        sut.bindData(fixtModel, imageWrapper, twoPane)

        verify(mockView).setRecipeIngredients(fixtModel.recipeIngredients)
        verify(mockView).setRecipeId(fixtModel.recipeId)
    }

    @Test
    fun onFavClick() {
        sut.onFavClick(fixtRecipeId, fixtState)

        verify(mockSharedPref).save(fixtRecipeId, fixtState)
        verify(mockView).setFavIcon(fixtState)
    }

    @Test
    fun onCollapseClick() {
        sut.onCollapseClick()

        verify(mockInteraction).onCollapseClick()
    }

    @Test
    fun bindLandFields() {
        sut.bindData(fixtModel, imageWrapper, twoPane = 2)

        verify(mockView).setRecipeName(fixtModel.title)
        verify(mockView).setRecipeRank(fixtModel.rank)
    }


    @Test
    fun doNotBindLandFieldsOnPortrait() {
        sut.bindData(fixtModel, imageWrapper, twoPane = 1)

        verify(mockView, never()).setRecipeName(fixtModel.recipeIngredients)
        verify(mockView, never()).setRecipeRank(fixtModel.recipeId)
    }
}
