package com.example.cocktails.presentation.dashboard.view.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cocktails.R
import com.example.cocktails.utils.navigation.AppScreens

@Composable
fun MainBottomBar(
//    navController: NavHostController,
//    state: MutableState<Boolean>,
    modifier: Modifier = Modifier,
) {
    val screens = listOf(
        AppScreens.DashboardScreen,
    )
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar {
        // TODO load navigation menu here
        screens.forEach { screen ->
            NavigationBarItem(
                label = {
                    Text(text = screen.title)
                },
                selected = false, //currentRoute == screen.route,
                onClick = {
                    /*navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }*/
                },
                icon = { screen.icon },
            )
        }
    }
}

@Preview
@Composable
fun MainBottomBarPreview() {
    MainBottomBar()
}