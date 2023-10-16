package com.example.cocktails.domain.usecase.cocktails.random

import com.example.cocktails.data.service.parsed.Cocktail
import com.example.cocktails.domain.repository.cocktail.CocktailRepository
import javax.inject.Inject

class GetRandomCocktailUseCaseImpl @Inject constructor(
    private val cocktailRepository: CocktailRepository,
) : GetRandomCocktailUseCase {
    override suspend operator fun invoke(parameters: Unit?): Cocktail {
        return cocktailRepository.getRandomCocktail()
    }
}