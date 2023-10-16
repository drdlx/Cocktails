package com.example.cocktails.presentation.screens.dashboard.vm

import com.example.cocktails.core.presentation.vm.Reducer
import com.example.cocktails.presentation.screens.dashboard.model.DashboardUiEvent
import com.example.cocktails.presentation.screens.dashboard.model.DashboardUiState

class DashboardScreenReducer(initial: DashboardUiState): Reducer<DashboardUiState, DashboardUiEvent>(initial) {

    override fun reduce(oldState: DashboardUiState, event: DashboardUiEvent) {
        when (event) {
            is DashboardUiEvent.ShowData -> {
                setState(oldState.copy(isLoading = false, data = event.items))
            }
            DashboardUiEvent.DismissDialog -> {}
        }
    }
}