package com.example.cocktails.presentation.coroutines.dispatcher

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DispatcherModule {
    @Provides
    @Singleton
    fun provideDispatcher(): AppDispatchers = AppDispatchers()
}