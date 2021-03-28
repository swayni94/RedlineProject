package com.example.redline_project

import android.app.Application
import com.example.redline_project.injection.component.AppComponent
import com.example.redline_project.injection.component.DaggerAppComponent
import com.example.redline_project.injection.modules.AppModule
import com.example.redline_project.injection.modules.StorageModule
import com.facebook.stetho.Stetho

open class MainApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
        initStetho()
    }

    private fun initDagger(app: MainApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
         //   .storageModule(StorageModule(app))
            .build()

    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }
}