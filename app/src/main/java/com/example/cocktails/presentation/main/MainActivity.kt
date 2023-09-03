package com.example.cocktails.presentation.main

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.cocktails.presentation.dashboard.view.components.MainBottomBar
import com.example.cocktails.ui.theme.CocktailsTheme
import com.example.cocktails.utils.navigation.AppNavigation
import com.example.cocktails.utils.navigation.graphs.mainFlowGraph
import com.example.cocktails.utils.navigation.popRouteName
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : ComponentActivity() {
    companion object {
        private const val navigationLaunchEffectName = "Navigator"
    }

    // TODO add dagger
//    @Inject
//    lateinit var navigator: AppNavigation
    private val navigator = AppNavigation()

    override fun onResume() {
        super.onResume()
        setContent {
            // TODO move it to a separate compose thingy
            CocktailsTheme {
                val navigationController = rememberNavController()
                // Listen to the scroll state to update the visibility of buttons
                LaunchedEffect(navigationLaunchEffectName) {
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

                val bottomBarHeight = 56.dp
                val bottomBarOffsetHeightPx = remember { mutableFloatStateOf(0f) }

                val buttonsVisible = remember { mutableStateOf(true) }
                LaunchedEffect(bottomBarOffsetHeightPx.floatValue) {
                    buttonsVisible.value = bottomBarOffsetHeightPx.floatValue >= -5
                }

                Scaffold(
                    modifier = Modifier.bottomBarAnimatedScroll(
                        height = bottomBarHeight, offsetHeightPx = bottomBarOffsetHeightPx
                    ),
                    bottomBar = {
                        MainBottomBar(
                            navController = navigationController,
                            state = buttonsVisible
                        )
                    }
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        NavHost(
                            navController = navigationController,
                            startDestination = mainFlowGraph
                        ) {
                            mainFlowGraph(navigationController)
                            // other flow graphs go here
                        }
                    }
                }
            }
        }
    }

    private fun Modifier.bottomBarAnimatedScroll(
        height: Dp = 56.dp, offsetHeightPx: MutableState<Float>
    ): Modifier = composed {
        val bottomBarHeightPx = with(LocalDensity.current) {
            height.roundToPx().toFloat()
        }
        val nestedScrollConnection = remember {
            object : NestedScrollConnection {
                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                    val delta = available.y
                    val newOffset = offsetHeightPx.value + delta
                    offsetHeightPx.value = newOffset.coerceIn(-bottomBarHeightPx, 0f)
                    return Offset.Zero
                }
            }
        }
        this.nestedScroll(nestedScrollConnection)
    }

}