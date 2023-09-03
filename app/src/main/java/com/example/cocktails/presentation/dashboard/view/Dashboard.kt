package com.example.cocktails.presentation.dashboard.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cocktails.presentation.dashboard.view.components.MainBottomBar
import com.example.cocktails.utils.navigation.AppScreens

@Composable
fun DashboardScreen() {
    Scaffold(
        modifier = (Modifier.padding(0.dp)),
        bottomBar = { MainBottomBar() }
    ) {
        Column() {
            // top bar
            Row() {
                Text("Popular drinks")
            }
            Row() {
                Text("Popular ingredients")
            }
            Row() {
                Text("Latest drinks")
            }
        }
    }

}

@Preview
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}