package com.example.cocktails.utils.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.cocktails.presentation.dashboard.view.DashboardScreen
import com.example.cocktails.utils.navigation.AppScreens

fun NavGraphBuilder.mainFlowGraph(navController: NavController) {
    navigation(startDestination = AppScreens.DashboardScreen.route, route = mainGraph) {
        composable(route = AppScreens.DashboardScreen.route) {
            DashboardScreen()
        }
        // different composable pages go here
    }
    /*navigation(startDestination = AppScreens.MainAppScreen.route, route = loggedUserGraph) {
        composable(route = AppScreens.MainAppScreen.route) {
            val viewModel = hiltViewModel<MainScreenViewModel>()
            MainPageScreen(
                uiState = viewModel.uiState
            )
        }

        composable(route = AppScreens.TransactionsScreen.route) {
            val viewModel = hiltViewModel<TransactionsViewModel>()
            TransactionsScreen(
                uiState = viewModel.uiState,
                initDataCallback = viewModel::initScreen,
                applyFilters = viewModel::loadLocallyFilteredTransactions
            )
        }
    }*/
}