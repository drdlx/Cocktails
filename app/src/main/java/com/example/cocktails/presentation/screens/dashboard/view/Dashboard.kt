package com.example.cocktails.presentation.screens.dashboard.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cocktails.core.utils.EMPTY_COCKTAIL
import com.example.cocktails.presentation.screens.dashboard.model.DashboardUiState
import com.example.cocktails.presentation.screens.dashboard.view.components.elements.DashboardCocktailItem
import com.example.cocktails.presentation.screens.dashboard.vm.DashboardViewModel

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
) {

    val state = viewModel.state.collectAsState(initial = DashboardUiState.initial())

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val padding = 16.dp
        val viewMaxWidth = maxWidth
        val viewMaxHeight = maxHeight

        if (state.value.isLoading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val cocktailsList = state.value.data

            items(cocktailsList.size) {
                Spacer(modifier = Modifier.height(16.dp))
                DashboardCocktailItem(
                    size = viewMaxWidth - padding * 2,
                    itemData = cocktailsList[it],
                )
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}

//@Preview
//@Composable
//fun DashboardScreenPreview() {
//    DashboardScreen()
//}