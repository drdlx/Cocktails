package com.example.cocktails.domain.repository

import com.example.cocktails.domain.repository.cocktail.CocktailRepository
import com.example.cocktails.domain.repository.cocktail.CocktailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    @ViewModelScoped
    fun bindCocktailRepository(repository: CocktailRepositoryImpl): CocktailRepository
}