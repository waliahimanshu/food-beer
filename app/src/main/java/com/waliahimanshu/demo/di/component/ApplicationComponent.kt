package com.waliahimanshu.demo.di.component

import android.app.Application
import com.waliahimanshu.demo.DemoApplication
import com.waliahimanshu.demo.di.module.ActivityBuilder
import com.waliahimanshu.demo.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (ApplicationModule::class),
    (ActivityBuilder::class),
    (AndroidInjectionModule::class),
    (AndroidSupportInjectionModule::class)])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: DemoApplication)
}
