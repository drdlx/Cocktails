package com.example.cocktails.core.di

import com.example.cocktails.utils.navigation.AppNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideNavigation(): AppNavigation = AppNavigation()
}