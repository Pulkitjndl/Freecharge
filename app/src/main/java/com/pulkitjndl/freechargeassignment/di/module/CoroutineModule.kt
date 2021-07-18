package com.pulkitjndl.freechargeassignment.di.module

import com.pulkitjndl.freechargeassignment.di.DefaultDispatcher
import com.pulkitjndl.freechargeassignment.di.IoDispatcher
import com.pulkitjndl.freechargeassignment.di.MainDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Aakib
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */
@Module
object CoroutinesModule {

    @DefaultDispatcher
    @JvmStatic
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @JvmStatic
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @JvmStatic
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}