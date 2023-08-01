package com.example.cocktails.core.screen.vm.tc

import com.example.cocktails.core.screen.vm.UiState

interface TimeCapsule<S: UiState> {
    fun addState(state: S)
    fun selectState(position: Int)
    fun getStates(): List<S>
}
