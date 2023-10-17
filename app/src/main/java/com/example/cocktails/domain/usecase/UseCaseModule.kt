package com.example.cocktails.domain.usecase

import com.example.cocktails.domain.usecase.cocktails.alcoholic.GetCocktailsByAlcoholicUseCase
import com.example.cocktails.domain.usecase.cocktails.alcoholic.GetCocktailsByAlcoholicUseCaseImpl
import com.example.cocktails.domain.usecase.cocktails.name.GetCocktailsByNameUseCase
import com.example.cocktails.domain.usecase.cocktails.name.GetCocktailsByNameUseCaseImpl
import com.example.cocktails.domain.usecase.cocktails.random.GetRandomCocktailUseCase
import com.example.cocktails.domain.usecase.cocktails.random.GetRandomCocktailUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {
    @Binds
    @ViewModelScoped
    fun bindCocktailsByNameUseCase(getCocktailsByNameUseCaseImpl: GetCocktailsByNameUseCaseImpl): GetCocktailsByNameUseCase

    @Binds
    @ViewModelScoped
    fun bindRandomCocktailUseCase(getRandomCocktailUseCaseImpl: GetRandomCocktailUseCaseImpl): GetRandomCocktailUseCase

    @Binds
    @ViewModelScoped
    fun bindCocktailsByAlcoholicUseCase(getCocktailsByAlcoholicUseCase: GetCocktailsByAlcoholicUseCaseImpl): GetCocktailsByAlcoholicUseCase

}