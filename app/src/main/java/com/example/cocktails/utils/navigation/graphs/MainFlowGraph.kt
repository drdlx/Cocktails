package com.example.cocktails.utils.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.cocktails.presentation.dashboard.view.DashboardScreen
import com.example.cocktails.utils.navigation.AppScreens

fun NavGraphBuilder.mainFlowGraph(navController: NavController) {
    navigation(startDestination = AppScreens.DashboardScreen.route, route = mainFlowGraph) {
        composable(route = AppScreens.DashboardScreen.route) {
            // you can init viewmodel here, or add whatever you need to provide the data to the screen
            DashboardScreen()
        }
        // different composable pages go here
    }
}