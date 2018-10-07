package com.waliahimanshu.demo.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.waliahimanshu.demo.network.RecipeDomain
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val CACHE_CONTROL = "Cache-Control"
private const val BASE_URL: String = ""

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(getHttpLoggingInterceptor())
        builder.addNetworkInterceptor(getStethoInterceptor())
        return builder.build()
    }

    private fun getStethoInterceptor(): StethoInterceptor {
        return StethoInterceptor()
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun provideRetrofitRestAdapter(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideFood2ForkApiService(restAdapter: Retrofit): RecipeDomain {
        return restAdapter.create(RecipeDomain::class.java)
    }
}
