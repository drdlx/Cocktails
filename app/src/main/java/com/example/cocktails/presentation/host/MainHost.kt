package com.example.cocktails.presentation.host

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.cocktails.presentation.dashboard.view.components.MainBottomBar
import com.example.cocktails.presentation.dashboard.view.components.MainTopBar
import com.example.cocktails.ui.theme.CocktailsTheme
import com.example.cocktails.utils.navigation.graphs.mainFlowGraph

@Composable
fun MainHost(navigationController: NavHostController) {
    CocktailsTheme {

        val buttonsVisible = remember { mutableStateOf(true) }

        val bottomBarHeight = 56.dp
        val bottomBarOffsetHeightPx = remember { mutableFloatStateOf(0f) }

        LaunchedEffect(bottomBarOffsetHeightPx.floatValue) {
            buttonsVisible.value = bottomBarOffsetHeightPx.floatValue >= -5
        }

        val pageName = navigationController.currentBackStackEntry?.destination?.displayName ?: LocalContext.current.applicationInfo.loadLabel(
            LocalContext.current.packageManager).toString()         // TODO move it to a ViewModel

        Scaffold(
            modifier = Modifier/*.bottomBarAnimatedScroll(
                height = bottomBarHeight, offsetHeightPx = bottomBarOffsetHeightPx
            )*/,
            topBar = { MainTopBar(pageName) },
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

private fun Modifier.bottomBarAnimatedScroll(height: Dp = 56.dp, offsetHeightPx: MutableState<Float>) = composed {
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
