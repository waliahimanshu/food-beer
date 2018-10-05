package com.waliahimanshu.demo.ui.home

import com.waliahimanshu.demo.util.BasePresenter
import com.waliahimanshu.demo.util.BaseView

interface RecipesEntryContract {
    interface View : BaseView<Presenter> {
        fun showProgressBar(show: Boolean)
        fun showEmptyState()
    }

    interface Presenter : BasePresenter {
        fun onDestroy()
        fun loadData()
    }
}
