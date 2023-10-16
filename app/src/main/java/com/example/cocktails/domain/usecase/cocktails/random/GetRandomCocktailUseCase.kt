package com.example.cocktails.domain.usecase.cocktails.random

import com.example.cocktails.data.service.parsed.Cocktail
import com.example.cocktails.domain.usecase.CoroutineUseCase

interface GetRandomCocktailUseCase: CoroutineUseCase<Cocktail, Unit>