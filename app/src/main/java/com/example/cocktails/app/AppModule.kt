package com.example.cocktails.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun providesApplication(): Application = app

    @Provides
    @Singleton
    fun provideContext(): Context = app
}