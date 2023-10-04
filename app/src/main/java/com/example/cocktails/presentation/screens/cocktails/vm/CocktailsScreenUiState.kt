package com.example.cocktails.presentation.screens.cocktails.vm

import androidx.compose.runtime.Immutable
import com.example.cocktails.core.screen.vm.UiState

@Immutable
data class CocktailsScreenUiState(
    val isLoading: Boolean,
//    val data: List<MainScreenItem>,
    val isShowAddDialog: Boolean,
) : UiState {

    companion object {
        fun initial() = CocktailsScreenUiState(
            isLoading = true,
//            data = emptyList(),
            isShowAddDialog = false
        )
    }

//    override fun toString(): String {
//        return "isLoading: $isLoading, data.size: ${data.size}, isShowAddDialog: $isShowAddDialog"
//    }
}