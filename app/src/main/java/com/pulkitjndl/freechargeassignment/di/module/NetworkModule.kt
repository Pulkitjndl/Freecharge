package com.pulkitjndl.freechargeassignment.di.module

import android.app.Application
import com.pulkitjndl.freechargeassignment.BuildConfig
import com.pulkitjndl.freechargeassignment.data.config.BASE_URL
import com.pulkitjndl.freechargeassignment.data.config.IO_TIMEOUT
import com.pulkitjndl.freechargeassignment.data.config.cacheSize
import com.pulkitjndl.freechargeassignment.data.remote.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Aakib
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */


@Module
class NetworkModule(private val application: Application) {


    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        val cache = Cache(application.cacheDir, cacheSize.toLong())
        // set your desired log level
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(IO_TIMEOUT, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG)
            client.addNetworkInterceptor{chain->
                val maxStale = 60 * 60 * 24 * 28 // tolerate 4-weeks stale \
                val request = chain.request()
                    .newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, max-stale=$maxStale")
                    .build()
                return@addNetworkInterceptor chain.proceed(request)
            }
        return client.build()
    }

    @Provides
    @Singleton
    fun providesConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(
        ApiService::class.java)
}