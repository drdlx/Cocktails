package com.example.cocktails.app

import android.app.Application
import com.example.cocktails.core.di.NavigationModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject
import android.util.Log

class App: Application() {

    private lateinit var appComponent: AppComponent

    companion object {
        private const val TAG = "App"
    }

    override fun onCreate() {
        createComponent()
        super.onCreate()
    }
    fun appComponent() = appComponent
    private fun createComponent() {
        Log.d(TAG, "Create app component")
        appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
//        appComponent = DaggerAppComponent.builder()
//            .appModule(AppModule(this))
//            .navigationModule(NavigationModule())
//            .build()
//            .apply { inject(this@App) }
//            .appModule(AppModule(this))
//            .navigationModule(NavigationModule())
//            .build()
    }


}