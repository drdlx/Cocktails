package com.example.cocktails.core.presentation.vm

import com.example.cocktails.BuildConfig
import com.example.cocktails.core.presentation.vm.tc.TimeTravelCapsule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class Reducer<S: UiState, E: UiEvent>(initialValue: S) {

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialValue)
    val state: StateFlow<S>
        get() = _state

    val timeCapsule: TimeTravelCapsule<S> = TimeTravelCapsule { storedState ->
        _state.tryEmit(storedState)
    }

    init {
        timeCapsule.addState(initialValue)
    }

    fun sendEvent(event: E) {
        reduce(_state.value, event)
    }

    fun setState(newState: S) {
        val success = _state.tryEmit(newState)

        if (BuildConfig.DEBUG && success) {
            timeCapsule.addState(newState)
        }
    }

    abstract fun reduce(oldState: S, event: E)

}