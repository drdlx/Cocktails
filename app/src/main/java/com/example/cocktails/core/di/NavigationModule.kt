package com.example.cocktails.core.di

import com.example.cocktails.utils.navigation.AppNavigation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule() {
    @Provides
    @Singleton
    fun provideNavigation(): AppNavigation = AppNavigation()
}
