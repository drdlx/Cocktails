package com.example.cocktails.presentation.screens.cocktail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.cocktails.presentation.screens.cocktail.view.components.CocktailTag

val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
val instructions = listOf("Step 1", "Step 2", "Step 3")
@Composable
fun CocktailScreen() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val padding = 16.dp
        val viewMaxWidth = maxWidth
        val viewMaxHeight = maxHeight
        LazyColumn() {
            item {
                Box(
                    modifier = Modifier
                        .size(maxWidth),
                    contentAlignment = Alignment.BottomStart

                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Cocktail image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                        text = "Cocktail name",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
            item {
                LazyRow(modifier = Modifier.padding(top = padding)) {
                    item { CocktailTag(text = "Tag1", onClick = {}) }
                    item { CocktailTag(text = "Tag2", onClick = {}) }
                    item { CocktailTag(text = "Tag3", onClick = {}) }
                    item { CocktailTag(text = "Tag4", onClick = {}) }
                    item { CocktailTag(text = "Tag5", onClick = {}) }
                    item { Row(modifier = Modifier.padding(end = padding)) { CocktailTag(text = "Tag5", onClick = {}) } }
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
                    Text("Glass description")
                    val serveHeader = "How to serve"
                    Text(
                        modifier = Modifier,
                        text = serveHeader,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text("How to serve description")
                    val categoryHeader = "Category"
                    Text(
                        modifier = Modifier,
                        text = categoryHeader,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    OutlinedButton(onClick = {}) {
                        Text("Category name")
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