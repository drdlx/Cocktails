package com.example.cocktails.presentation.main

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.cocktails.utils.navigation.AppNavigation
import com.example.cocktails.utils.navigation.AppScreens
import com.example.cocktails.utils.navigation.graphs.mainFlowGraph
import com.example.cocktails.utils.navigation.popRouteName
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : ComponentActivity() {
    companion object {
        private const val launchEffectName = "Navigator"
    }

// TODO add dagger
//    @Inject
//    lateinit var navigator: AppNavigation
    val navigator = AppNavigation()

    override fun onResume() {
        super.onResume()
        setContent {
            val navigationController = rememberNavController()

            LaunchedEffect(launchEffectName) {
                navigator.navRoute.onEach {
                    when (it.route) {
                        popRouteName -> {
                            when (it.popTargetRoute.isEmpty()) {
                                true -> navigationController.popBackStack()
                                false -> navigationController.popBackStack(
                                    it.popTargetRoute,
                                    it.inclusive,
                                    it.saveState
                                )
                            }
                        }
                        else -> navigationController.navigate(it.route, it.options)
                    }
                }.launchIn(this)
            }

            NavHost(navController = navigationController, startDestination = mainFlowGraph) {
                mainFlowGraph(navigationController)
                // other flow graphs go here
            }
        }
    }
}
