package com.waliahimanshu.demo.ui.home

interface RecipesFragmentContract {

    interface Presenter {
        fun onDestroy()
        fun loadData(response: Int)
    }

    interface View {
        fun showProgressBar(show: Boolean)
        fun bindData(map: List<RecipeModel>)
        fun showEmptyState()
    }
}
