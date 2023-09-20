package com.example.cocktails.presentation.dashboard.view.components.elements

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cocktails.R

@Composable
fun DashboardItem(
    size: Dp,
) = Column {
    val shape =  RoundedCornerShape(8.dp)
    Box(
        modifier = Modifier
            .size(size)
            .clip(shape = shape),
        contentAlignment = Alignment.BottomCenter

    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Cocktail image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape)
        )
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Text",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
        )
    }
}

@Preview
@Composable
fun DashboardItemPreview() {
    DashboardItem(size = 150.dp)
}