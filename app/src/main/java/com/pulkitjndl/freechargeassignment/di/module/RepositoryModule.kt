package com.pulkitjndl.freechargeassignment.di.module

import com.pulkitjndl.freechargeassignment.data.remote.ApiService
import com.pulkitjndl.freechargeassignment.data.remote.RemoteDataSourceImpl
import com.pulkitjndl.freechargeassignment.di.IoDispatcher
import com.pulkitjndl.freechargeassignment.repo.AppRepositoryImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

/**
 * Created by Aakib
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAppRepository(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        api: ApiService
    ): AppRepositoryImpl {
        val remoteDataSource = RemoteDataSourceImpl(api, ioDispatcher)
        return AppRepositoryImpl(remoteDataSource, ioDispatcher)
    }
}