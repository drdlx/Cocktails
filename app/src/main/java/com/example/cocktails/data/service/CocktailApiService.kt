package com.example.cocktails.data.service

import com.example.cocktails.data.service.models.raw.CocktailRaw
import com.example.cocktails.data.service.models.raw.CocktailsRaw
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/*
* API Access points
*/
interface CocktailApiService {
    @GET("lookup.php?i=11007")
    fun getCocktail(): Response<CocktailsRaw>

    @GET("random.php")
    suspend fun getRandomCocktail(): Response<CocktailsRaw>
}