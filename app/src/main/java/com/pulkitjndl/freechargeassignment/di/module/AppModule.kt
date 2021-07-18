package com.pulkitjndl.freechargeassignment.di.module

import android.app.Application
import android.content.Context
import com.pulkitjndl.freechargeassignment.di.viewmodels.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Aakib
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */
@Module(includes = [ViewModelModule::class])
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return application
    }
}