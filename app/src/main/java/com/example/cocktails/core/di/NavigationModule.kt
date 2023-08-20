package com.example.cocktails.core.di

import com.example.cocktails.utils.navigation.AppNavigation
import dagger.Module
import javax.inject.Singleton

@Module
class NavigationModule() {
    @Singleton
    fun provideNavigation(): AppNavigation = AppNavigation()
}
