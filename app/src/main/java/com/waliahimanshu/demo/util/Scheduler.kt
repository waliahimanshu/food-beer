package com.waliahimanshu.demo.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Scheduler @Inject constructor() : IScheduler {

    private object InstanceHolder {
        internal val INSTANCE = com.waliahimanshu.demo.util.Scheduler()
    }

    override fun background(): Scheduler {
        return Schedulers.io()
    }

    override fun main(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    companion object {

        val instance: com.waliahimanshu.demo.util.Scheduler
            get() = InstanceHolder.INSTANCE
    }
}
