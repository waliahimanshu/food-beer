package com.waliahimanshu.foodbeer.util

import io.reactivex.Scheduler

interface IScheduler {

    fun background(): Scheduler


    fun main(): Scheduler
}
