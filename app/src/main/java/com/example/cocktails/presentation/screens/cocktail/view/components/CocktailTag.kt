package com.example.cocktails.presentation.screens.cocktail.view.components

import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CocktailTag(text: String, onClick: () -> Unit) {
    FilledTonalButton(onClick = onClick) {
        Text(text = text)
    }
}