package com.example.cocktails.presentation.screens.dashboard.model

import androidx.compose.runtime.Immutable
import com.example.cocktails.core.presentation.vm.UiState
import com.example.cocktails.core.utils.EMPTY
import com.example.cocktails.data.service.parsed.Cocktail

@Immutable
data class DashboardUiState(
    val isLoading: Boolean,
    val data: List<Cocktail>,
    val isShowError: String,
) : UiState {

    companion object {
        fun initial() = DashboardUiState(
            isLoading = true,
            data = emptyList(),
            isShowError = String.EMPTY
        )
    }

}