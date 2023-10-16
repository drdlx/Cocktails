package com.example.cocktails.core.presentation.vm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow

abstract class BaseViewModel<T: UiState, in E: UiEvent>: ViewModel() {
    abstract val state: Flow<T>
}