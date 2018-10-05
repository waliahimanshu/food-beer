package com.waliahimanshu.demo.ui.home

import javax.inject.Inject


class RecipesEntryPresenter @Inject constructor(private val mainView: RecipesEntryContract.View,
                                                mapper: RecpieEntryMapper) : RecipesEntryContract.Presenter {
    override fun loadData() {

    }


    override fun stop() {

    }

    override fun start() {
        loadData()
    }


    override fun onDestroy() {
    }
}
