package com.example.cocktails.domain.usecase.cocktails.alcoholic

import com.example.cocktails.data.service.parsed.Cocktail
import com.example.cocktails.domain.repository.cocktail.CocktailRepository
import javax.inject.Inject

class GetCocktailsByAlcoholicUseCaseImpl @Inject constructor(
    private val cocktailRepository: CocktailRepository,
): GetCocktailsByAlcoholicUseCase {
    override suspend fun invoke(parameters: Unit?): List<Cocktail> {
        return cocktailRepository.getCocktailsByAlcoholic()
    }
}