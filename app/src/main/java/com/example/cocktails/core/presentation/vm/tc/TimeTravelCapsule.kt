package com.example.cocktails.core.presentation.vm.tc

import com.example.cocktails.core.presentation.vm.UiState

class TimeTravelCapsule<S: UiState>(
    private val onStateSelected: (S) -> Unit
): TimeCapsule<S> {

    private val states = mutableListOf<S>()
    override fun addState(state: S) {
        states.add(state)
    }

    override fun selectState(position: Int) {
        onStateSelected(states[position])
    }

    override fun getStates(): List<S> {
        return states
    }

}