package com.example.cocktails.presentation.cocktails.vm

import com.example.cocktails.core.screen.vm.BaseViewModel
import com.example.cocktails.core.screen.vm.tc.TimeCapsule
import kotlinx.coroutines.flow.Flow

class CocktailsScreenViewModel: BaseViewModel<CocktailsScreenUiState, CocktailsScreenUiEvent>() {

    private val reducer = CocktailsScreenReducer(CocktailsScreenUiState.initial())

    val timeMachine: TimeCapsule<CocktailsScreenUiState>
        get() = reducer.timeCapsule
    override val state: Flow<CocktailsScreenUiState>
        get() = reducer.state

}