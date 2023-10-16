package com.example.cocktails.data.service.parsed

data class Ingredient(
    val ingredientId: String?,
    val ingredientName: String?,
    val description: String,
    val ingredientType: String,
    val isAlcohol: Boolean,
    val strABV: String?,
)
