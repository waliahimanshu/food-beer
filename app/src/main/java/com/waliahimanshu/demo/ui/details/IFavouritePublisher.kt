package com.waliahimanshu.demo.ui.details

import io.reactivex.subjects.PublishSubject

interface IFavouritePublisher {

    fun publish(event: Boolean)
    fun getStream(): PublishSubject<Boolean>
}
