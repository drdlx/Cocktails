package com.example.cocktails.data.service.models.raw

import com.example.cocktails.core.utils.EMPTY
import com.example.cocktails.data.service.parsed.Cocktail
import com.example.cocktails.data.service.parsed.IngredientWithMeasure
import com.google.gson.annotations.SerializedName
import java.io.Serial

data class CocktailsRaw(
    @SerializedName("drinks")
    val drinks: List<CocktailRaw>
)

fun CocktailRaw.toCocktail(): Cocktail {

    val tags = this.strTags?.split(',')?.map { it.trim() } ?: emptyList()
    val isAlcoholic = this.strAlcoholic == "Alcoholic"

    val instructions = listOf<String>()
    val ingredientsWithMeasures = listOf<IngredientWithMeasure>()
    val creativeCommonsConfirmed = this.strCreativeCommonsConfirmed == "Yes"

    return Cocktail(
        drinkId = this.idDrink ?: String.EMPTY,
        drinkName = this.strDrink ?: String.EMPTY,
        tags = tags,
        category = this.strCategory ?: String.EMPTY,
        ibaCategory = this.strIBA ?: String.EMPTY,
        isAlcoholic = isAlcoholic,
        glass = this.strGlass ?: String.EMPTY,
        instructions = instructions,
        drinkThumbnailUrl = this.strDrinkThumb,
        ingredientsWithMeasures = ingredientsWithMeasures,
        imageUrl = this.strImageSource ?: String.EMPTY,
        strImageAttribution = this.strImageAttribution ?: String.EMPTY,
        strCreativeCommonsConfirmed = creativeCommonsConfirmed,
        dateModified = this.dateModified
    )
}
