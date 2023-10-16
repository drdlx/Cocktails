package com.example.cocktails.domain.usecase.cocktails.name

import com.example.cocktails.domain.repository.cocktail.CocktailRepository
import com.example.cocktails.data.service.parsed.Cocktail
import javax.inject.Inject

class GetCocktailsByNameUseCaseImpl @Inject constructor(
    private val cocktailRepository: CocktailRepository,
): GetCocktailsByNameUseCase {
    override suspend operator fun invoke(parameters: Unit?): List<Cocktail> {
        TODO()
//        return cocktailRepository.getRandomCocktail()
    }
}