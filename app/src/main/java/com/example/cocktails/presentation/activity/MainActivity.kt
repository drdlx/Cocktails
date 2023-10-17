package com.example.cocktails.presentation.activity

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.example.cocktails.presentation.screens.host.MainHost
import com.example.cocktails.utils.navigation.AppNavigation
import com.example.cocktails.utils.navigation.popRouteName
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        private const val navigationLaunchEffectName = "Navigator"
    }

    @Inject
    lateinit var navigator: AppNavigation

    override fun onResume() {
        super.onResume()

        setContent {
            val navigationController = rememberNavController()
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

            MainHost(navigationController)

        }
    }
}