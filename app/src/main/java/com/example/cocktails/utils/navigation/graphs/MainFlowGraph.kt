package com.example.cocktails.utils.navigation.graphs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.cocktails.presentation.screens.cocktails.CocktailsScreen
import com.example.cocktails.presentation.screens.dashboard.view.DashboardScreen
import com.example.cocktails.presentation.screens.dashboard.vm.DashboardViewModel
import com.example.cocktails.utils.navigation.AppScreens

fun NavGraphBuilder.mainFlowGraph(navController: NavController) {
    navigation(startDestination = AppScreens.DashboardScreen.route, route = mainFlowGraph) {
        composable(route = AppScreens.DashboardScreen.route) {
            // you can init viewmodel here, or add whatever you need to provide the data to the screen
            val viewModel = hiltViewModel<DashboardViewModel>()
            DashboardScreen(viewModel = viewModel)
        }

        composable(route = AppScreens.CocktailsScreen.route) {
            // you can init viewmodel here, or add whatever you need to provide the data to the screen
            CocktailsScreen()
        }
        // different composable pages go here
    }
}