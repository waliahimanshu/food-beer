package com.waliahimanshu.demo.util


interface BaseView<in T : BasePresenter> {

    fun setPresenter(presenter: T)

}
