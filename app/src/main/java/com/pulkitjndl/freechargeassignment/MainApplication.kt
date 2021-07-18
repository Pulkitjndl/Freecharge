package com.pulkitjndl.freechargeassignment

import android.app.Application
import com.pulkitjndl.freechargeassignment.di.components.AppComponents
import com.pulkitjndl.freechargeassignment.di.components.DaggerAppComponents
import com.pulkitjndl.freechargeassignment.di.module.AppModule
import com.pulkitjndl.freechargeassignment.di.module.NetworkModule

/**
 * Created by Pulkit Jindal
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */

open class MainApplication : Application() {

    companion object {
        lateinit var appComponents: AppComponents
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDagger(this)
    }

    private fun initDagger(mainApplication: MainApplication): AppComponents =
        DaggerAppComponents.builder()
            .appModule(AppModule(mainApplication))
            .networkModule(NetworkModule(mainApplication))
            .build()
}