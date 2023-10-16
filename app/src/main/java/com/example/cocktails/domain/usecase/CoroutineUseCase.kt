package com.example.cocktails.domain.usecase

interface CoroutineUseCase<out Output, in Parameters> {

    suspend operator fun invoke(parameters: Parameters? = null): Output

}