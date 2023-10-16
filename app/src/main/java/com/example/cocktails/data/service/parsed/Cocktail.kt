package com.example.cocktails.data.service.parsed

import com.example.cocktails.core.utils.EMPTY

data class Cocktail(
    val drinkId: String,
    val drinkName: String,
    val tags: List<String>,
    val category: String,
    val ibaCategory: String,
    val isAlcoholic: Boolean,
    val glass: String,
    val instructions: List<String>,
    val drinkThumbnailUrl: String?,
    val ingredientsWithMeasures: List<IngredientWithMeasure>,
    val imageUrl: String,
    val strImageAttribution: String?,
    val strCreativeCommonsConfirmed: Boolean,
    val dateModified: String?,
)
