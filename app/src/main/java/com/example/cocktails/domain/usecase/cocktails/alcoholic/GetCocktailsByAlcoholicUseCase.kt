package com.example.cocktails.domain.usecase.cocktails.alcoholic

import com.example.cocktails.data.service.parsed.Cocktail
import com.example.cocktails.domain.usecase.CoroutineUseCase

interface GetCocktailsByAlcoholicUseCase: CoroutineUseCase<List<Cocktail>, Unit>