package com.example.cocktails.presentation.screens.cocktail.model

data class CocktailInfo(
    val cocktailName: String,
    val cocktailImageUri: String,
    val cocktailTags: List<String>,
    val cocktailIngredients: List<CocktailIngredient>,
    val cocktailInstructions: List<String>,
    val cocktailGlass: String,
    val cocktailServing: String,
    val cocktailCategory: String,
)
