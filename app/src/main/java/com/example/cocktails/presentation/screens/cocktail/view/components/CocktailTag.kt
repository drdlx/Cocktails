package com.example.cocktails.presentation.screens.cocktail.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CocktailTag(text: String, onClick: () -> Unit) {
    val paddingStart = 16.dp
    FilledTonalButton(modifier = Modifier.padding(start = paddingStart), onClick = onClick) {
        Text(text = text)
    }
}