package com.example.cocktails.presentation.screens.cocktails.vm

import androidx.compose.runtime.Immutable
import com.example.cocktails.core.presentation.vm.UiState
import com.example.cocktails.core.utils.EMPTY
import com.example.cocktails.data.service.parsed.Cocktail

@Immutable
data class CocktailsScreenUiState(
    val isLoading: Boolean,
    val data: List<Cocktail>,
    val isShowError: String,
) : UiState {

    companion object {
        fun initial() = CocktailsScreenUiState(
            isLoading = true,
            data = emptyList(),
            isShowError = String.EMPTY
        )
    }

//    override fun toString(): String {
//        return "isLoading: $isLoading, data.size: ${data.size}, isShowAddDialog: $isShowAddDialog"
//    }
}