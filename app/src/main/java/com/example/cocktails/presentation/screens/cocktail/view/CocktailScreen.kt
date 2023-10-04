package com.example.cocktails.presentation.screens.cocktail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cocktails.R
import com.example.cocktails.presentation.screens.cocktail.model.CocktailInfo
import com.example.cocktails.presentation.screens.cocktail.model.CocktailIngredient
import com.example.cocktails.presentation.screens.cocktail.view.components.CocktailTag

val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
val instructions = listOf("Step 1", "Step 2", "Step 3")

@Composable
fun CocktailScreen() {
    val cocktailInfo = CocktailInfo(
        cocktailName = "Cocktail name",
        cocktailImageUri = "URI",
        cocktailTags = listOf("Tag1", "Tag2", "Tag3"),
        cocktailIngredients = listOf(CocktailIngredient("Ingredient 1", "URI", "Measure")),
        cocktailInstructions = listOf("Step 1", "Step 2", "Step 3"),
        cocktailGlass = "Glass",
        cocktailServing = "Serving",
        cocktailCategory = "Category",
    )
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val padding = 16.dp
        LazyColumn() {
            item {
                Box(
                    modifier = Modifier
                        .size(maxWidth),
                    contentAlignment = Alignment.BottomStart

                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
                        contentDescription = cocktailInfo.cocktailName,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                        text = cocktailInfo.cocktailName,
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
            item {
                LazyRow(modifier = Modifier.padding(top = padding)) {
                    cocktailInfo.cocktailTags.first().also {
                        item {
                            Column(modifier = Modifier.padding(start = padding)) {
                                CocktailTag(
                                    text = it,
                                    onClick = {})
                            }
                        }
                    }
                    if (cocktailInfo.cocktailTags.size > 1) {
                        for (i in 1..<cocktailInfo.cocktailTags.size) {
                            item {
                                Column(modifier = Modifier.padding(start = padding)) {
                                    CocktailTag(
                                        text = cocktailInfo.cocktailTags[i],
                                        onClick = {})
                                }
                            }
                        }
                    }
                }
            }
            item {
                Column(modifier = Modifier.padding(start = padding, top = padding)) {
                    val ingredientsHeader = "Ingredients"
                    Text(
                        modifier = Modifier,
                        text = ingredientsHeader,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Column() { Text("Ingredients + measures list") }
                    val instructionsHeader = "Instructions"
                    Text(
                        modifier = Modifier,
                        text = instructionsHeader,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Column() {
                        Text(
                            buildAnnotatedString {
                                instructions.forEach {
                                    withStyle(style = paragraphStyle) {
                                        append("\t\t")
                                        append(it)
                                    }
                                }
                            })
                    }
                    val glassHeader = "Glass"
                    Text(
                        modifier = Modifier,
                        text = glassHeader,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(cocktailInfo.cocktailGlass)
                    val serveHeader = "How to serve"
                    Text(
                        modifier = Modifier,
                        text = serveHeader,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(cocktailInfo.cocktailServing)
                    OutlinedButton(onClick = {}) {
                        Text(cocktailInfo.cocktailCategory)
                    }
                    Spacer(modifier = Modifier.height(padding))
                }
            }
        }
    }
}

@Preview
@Composable
fun CocktailScreenPreview() {
    CocktailScreen()
}