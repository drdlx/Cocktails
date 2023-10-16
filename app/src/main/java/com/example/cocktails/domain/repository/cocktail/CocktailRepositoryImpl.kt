package com.example.cocktails.domain.repository.cocktail

import android.util.Log
import com.example.cocktails.core.utils.EMPTY_COCKTAIL
import com.example.cocktails.data.service.CocktailApiService
import com.example.cocktails.data.service.models.raw.BackendErrorResponseRaw
import com.example.cocktails.data.service.models.raw.toCocktail
import com.example.cocktails.data.service.parsed.Cocktail
import com.example.cocktails.data.service.parsed.Ingredient
import com.example.cocktails.presentation.coroutines.dispatcher.AppDispatcher
import com.google.gson.Gson
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val cocktailApiService: CocktailApiService,
    private val dispatcher: AppDispatcher,

    ): CocktailRepository {
    override suspend fun getCocktailById(cocktailId: String): Cocktail {
        TODO("Not yet implemented")
    }

    private val gson = Gson()

    override suspend fun getRandomCocktail(): Cocktail = withContext(dispatcher.io) {
        val response = cocktailApiService.getRandomCocktail()
        when (response.isSuccessful) {
            true -> {
                return@withContext response.body()?.drinks?.first()?.toCocktail() ?: EMPTY_COCKTAIL
            }
            else -> {
                Log.e(TAG, response.code().toString())
                throw Exception(getMessage(response.errorBody()))
            }
        }
    }

    override suspend fun getCocktailsByName(cocktailName: String): List<Cocktail> {
        TODO("Not yet implemented")
    }

    override suspend fun getIngredientById(ingredientId: String): Ingredient {
        TODO("Not yet implemented")
    }

    private fun getMessage(errorBody: ResponseBody?): String {
        return try {
            val error = gson.fromJson(errorBody!!.string(), BackendErrorResponseRaw::class.java)
            error.result
        } catch (parseError: Exception) {
            defaultErrorMessage
        }
    }

    companion object {
        private const val TAG = "CocktailRepositoryImpl"
        const val defaultErrorMessage = "Unknown back error"
    }
}