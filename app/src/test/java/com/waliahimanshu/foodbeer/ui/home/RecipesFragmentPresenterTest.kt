package com.waliahimanshu.foodbeer.ui.home

import com.flextrade.jfixture.FixtureAnnotations
import com.flextrade.jfixture.annotations.Fixture
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.waliahimanshu.foodbeer.data.RecipeRepository
import com.waliahimanshu.foodbeer.data.UserRepository
import com.waliahimanshu.foodbeer.ui.home.domain.Recipes
import com.waliahimanshu.foodbeer.ui.home.dto.PersonDto
import com.waliahimanshu.foodbeer.ui.home.dto.RecipesDTO
import com.waliahimanshu.foodbeer.ui.home.mapper.RecipeEntryMapper
import com.waliahimanshu.foodbeer.util.TestSchedulerImpl
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class RecipesFragmentPresenterTest {

    @Mock
    private lateinit var mockView: RecipesFragmentContract.View
    @Mock
    private lateinit var mockMapper: RecipeEntryMapper

    @Mock
    private lateinit var mockRecipeRepo: RecipeRepository

    @Mock
    private lateinit var mockUserRepo: UserRepository

    private lateinit var sut: RecipesFragmentPresenter


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        FixtureAnnotations.initFixtures(this)
    }

    @Fixture
    private lateinit var fixtRecipesDto: List<RecipesDTO>

    @Fixture
    private lateinit var fixtUserDto: List<PersonDto>

    @Fixture
    private lateinit var fixtDomain: List<Recipes>

    @Test
    fun `loadData successfully`() {

        whenever(mockRecipeRepo.getAllRecipes()).thenReturn(Single.just(fixtRecipesDto))
        whenever(mockUserRepo.getProfiles()).thenReturn(Single.just(fixtUserDto))

        whenever(mockMapper.map(fixtRecipesDto, fixtUserDto)).thenReturn(fixtDomain)

        sut = RecipesFragmentPresenter(mockView, mockMapper, mockRecipeRepo, mockUserRepo, TestSchedulerImpl())

        sut.loadData()

        verify(mockView).bindData(fixtDomain)
    }

    @Test
    fun `loadData error`() {

        whenever(mockRecipeRepo.getAllRecipes()).thenReturn(Single.error(RuntimeException("Boom ")))
        whenever(mockUserRepo.getProfiles()).thenReturn(Single.just(fixtUserDto))

        whenever(mockMapper.map(fixtRecipesDto, fixtUserDto)).thenReturn(fixtDomain)

        sut = RecipesFragmentPresenter(mockView, mockMapper, mockRecipeRepo, mockUserRepo, TestSchedulerImpl())

        sut.loadData()

        verify(mockView).showError()
    }

    @Test
    fun onStop() {
        val mockDisposable = mock(CompositeDisposable::class.java)
        sut = RecipesFragmentPresenter(mockView, mockMapper, mockRecipeRepo, mockUserRepo, TestSchedulerImpl())
        sut.compositeDisposable = mockDisposable

        sut.onStop()

        verify(sut.compositeDisposable).clear()
    }
}
