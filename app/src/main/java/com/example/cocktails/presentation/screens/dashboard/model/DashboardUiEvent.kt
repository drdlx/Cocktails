package com.example.cocktails.presentation.screens.dashboard.model

import com.example.cocktails.core.presentation.vm.UiEvent
import com.example.cocktails.data.service.parsed.Cocktail
import javax.annotation.concurrent.Immutable

@Immutable
sealed class DashboardUiEvent: UiEvent {
    data class ShowData(val items: List<Cocktail>) : DashboardUiEvent()
    object DismissDialog : DashboardUiEvent()
}