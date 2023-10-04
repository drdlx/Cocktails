package com.example.cocktails.presentation.screens.dashboard.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cocktails.presentation.screens.dashboard.view.components.MainBottomBar
import com.example.cocktails.presentation.screens.dashboard.view.components.elements.DashboardItem
import com.example.cocktails.utils.navigation.AppScreens

@Composable
fun DashboardScreen() {

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val padding = 16.dp
        val viewMaxWidth = maxWidth
        val viewMaxHeight = maxHeight

        val shape =  RoundedCornerShape(8.dp)

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                DashboardItem(size = viewMaxWidth - padding * 2)
                Spacer(modifier = Modifier.height(16.dp))
                DashboardItem(size = viewMaxWidth - padding * 2)
                Spacer(modifier = Modifier.height(16.dp))
                DashboardItem(size = viewMaxWidth - padding * 2)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}