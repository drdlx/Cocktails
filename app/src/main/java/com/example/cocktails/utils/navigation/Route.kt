package com.example.cocktails.utils.navigation

import androidx.navigation.NavOptions

const val dashboardScreenRoute = "DashboardScreenRoute"
const val popRouteName = "popRoute"

sealed class AppScreens(
    val route: String,
    val options: NavOptions? = null,
    val inclusive: Boolean = false,
    val saveState: Boolean = false,
    val popTargetRoute: String = "",
) {
    object DashboardScreen: AppScreens(dashboardScreenRoute)

}
