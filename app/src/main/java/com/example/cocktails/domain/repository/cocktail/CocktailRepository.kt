package com.example.cocktails.domain.repository.cocktail

import com.example.cocktails.data.service.parsed.Cocktail
import com.example.cocktails.data.service.parsed.Ingredient
import com.example.cocktails.presentation.screens.cocktail.model.CocktailIngredient

interface CocktailRepository {
//    suspend fun getCocktails(): List<Cocktail>
//    suspend fun getCocktailsByCategory(categoryName: String): List<Cocktail>
//    suspend fun getCocktailsByIngredient(ingredientName: String): List<Cocktail>
    suspend fun getCocktailById(cocktailId: String): Cocktail
    suspend fun getRandomCocktail(): Cocktail
    suspend fun getCocktailsByName(cocktailName: String): List<Cocktail>
    suspend fun getIngredientById(ingredientId: String): Ingredient
    suspend fun getCocktailsByAlcoholic(): List<Cocktail>

}
