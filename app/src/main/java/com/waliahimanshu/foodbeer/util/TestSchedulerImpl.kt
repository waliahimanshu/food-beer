package com.waliahimanshu.foodbeer.util

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulerImpl : IScheduler {

    override fun background(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun main(): io.reactivex.Scheduler {
        return Schedulers.trampoline()
    }
}
