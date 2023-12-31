package com.example.cocktails.utils.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class AppNavigation() {
    private val _navRoute =
        MutableSharedFlow<AppScreens>(extraBufferCapacity = 1)

    val navRoute = _navRoute.asSharedFlow()

    fun navigateTo(destination: AppScreens) {
        _navRoute.tryEmit(destination)
    }

}