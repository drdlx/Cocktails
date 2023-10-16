package com.example.cocktails.core.utils

import com.example.cocktails.BuildConfig
import com.example.cocktails.data.service.parsed.Cocktail

private const val EMPTY_STRING = ""
const val API_KEY = BuildConfig.API_KEY
const val BASE_URL = BuildConfig.BASE_URL
const val STR_SLASH = "/"
val String.Companion.EMPTY: String
    get() = EMPTY_STRING

val EMPTY_COCKTAIL: Cocktail
    get() = Cocktail(
        drinkId = "-1",
        drinkName = String.EMPTY,
        tags = emptyList(),
        category = String.EMPTY,
        ibaCategory = String.EMPTY,
        isAlcoholic = false,
        glass = String.EMPTY,
        instructions = emptyList(),
        drinkThumbnailUrl = String.EMPTY,
        ingredientsWithMeasures = emptyList(),
        imageUrl = String.EMPTY,
        strImageAttribution = String.EMPTY,
        strCreativeCommonsConfirmed = false,
        dateModified = String.EMPTY
    )