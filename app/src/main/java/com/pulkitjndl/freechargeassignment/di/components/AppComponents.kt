package com.pulkitjndl.freechargeassignment.di.components

import android.content.Context
import com.pulkitjndl.freechargeassignment.di.module.*
import com.pulkitjndl.freechargeassignment.ui.dashboard.DashboardActivity
import com.pulkitjndl.freechargeassignment.ui.detail.DetailActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Aakib
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */
@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        CoroutinesModule::class,
        RoutingModule:: class
    ]
)

interface AppComponents {

    fun context(): Context

    fun retrofit(): Retrofit


    fun inject(dashboardActivity: DashboardActivity)
    fun inject(detailActivity: DetailActivity)
}