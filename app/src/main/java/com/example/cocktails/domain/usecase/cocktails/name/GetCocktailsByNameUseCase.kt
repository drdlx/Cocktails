package com.example.cocktails.domain.usecase.cocktails.name

import com.example.cocktails.data.service.parsed.Cocktail
import com.example.cocktails.domain.usecase.CoroutineUseCase

interface GetCocktailsByNameUseCase: CoroutineUseCase<List<Cocktail>, Unit>