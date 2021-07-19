package com.pulkitjndl.freechargeassignment.di.module

import com.pulkitjndl.freechargeassignment.ui.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pulkit Jindal
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */

@Module
class RoutingModule () {

    @Provides
    @Singleton
    fun provideRouter(): Router {
        return Router()
    }
}
