package com.waliahimanshu.demo.ui.details

import io.reactivex.subjects.PublishSubject

object FavouritePublish : IFavouritePublisher {
    val subject: PublishSubject<Boolean> = PublishSubject.create<Boolean>()

    override fun getStream(): PublishSubject<Boolean> {
        return subject
    }

    override fun publish(event: Boolean) {
        subject.onNext(event)
    }

}
