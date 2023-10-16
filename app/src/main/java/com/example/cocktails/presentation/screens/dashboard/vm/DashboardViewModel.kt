package com.example.cocktails.presentation.screens.dashboard.vm

import androidx.lifecycle.viewModelScope
import com.example.cocktails.core.presentation.vm.BaseViewModel
import com.example.cocktails.core.presentation.vm.tc.TimeCapsule
import com.example.cocktails.domain.usecase.cocktails.random.GetRandomCocktailUseCase
import com.example.cocktails.presentation.coroutines.dispatcher.AppDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import com.example.cocktails.presentation.screens.dashboard.model.DashboardUiEvent
import com.example.cocktails.presentation.screens.dashboard.model.DashboardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DashboardViewModel @Inject constructor(
    val getRandomCocktailUseCase: GetRandomCocktailUseCase,
): BaseViewModel<DashboardUiState, DashboardUiEvent>() {

    private val reducer = DashboardScreenReducer(DashboardUiState.initial())

    init {
        viewModelScope.launch {
            val data = getRandomCocktailUseCase()
            sendEvent(DashboardUiEvent.ShowData(listOf(data)))
        }
    }

    private fun sendEvent(event: DashboardUiEvent) {
        reducer.sendEvent(event)
    }

    val timeMachine: TimeCapsule<DashboardUiState>
        get() = reducer.timeCapsule

    override val state: Flow<DashboardUiState>
        get() = reducer.state

}