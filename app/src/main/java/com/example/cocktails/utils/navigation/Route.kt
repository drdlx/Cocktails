package com.example.cocktails.utils.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationBarItemDefaults.colors
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavOptions
import com.example.cocktails.core.utils.EMPTY

const val dashboardScreenRoute = "DashboardScreenRoute"
const val cocktailsScreenRoute = "CocktailsScreenRoute"
//const val dashboardScreenRoute = "DashboardScreenRoute"
const val popRouteName = "popRoute"

sealed class AppScreens(
    val route: String,
    val options: NavOptions? = null,
    val inclusive: Boolean = false,
    val saveState: Boolean = false,
    val popTargetRoute: String = String.EMPTY,
    val title: String = String.EMPTY,
    val icon: ImageVector = Icons.Default.Person,
) {
    object DashboardScreen: AppScreens(
        dashboardScreenRoute,
        NavOptions.Builder().setPopUpTo(0, false).build(),
        title = "Dashboard",
        icon = Icons.Outlined.Home,
    )
    object CocktailsScreen: AppScreens(
        cocktailsScreenRoute,
        NavOptions.Builder().setPopUpTo(0, false).build(),
        title = "Cocktails",
        icon = Icons.Outlined.ShoppingCart,
    )

}
