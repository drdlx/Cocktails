package com.example.cocktails.presentation.dashboard.view.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cocktails.R

@Composable
fun MainBottomBar() {
    NavigationBar {
        // TODO load navigation menu here
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = {
                Text(text = "Test1")
            },
            icon = { Icon(modifier = Modifier.height(48.dp), painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = {
                Text(text = "Test1")
            },
            icon = { Icon(modifier = Modifier.height(48.dp), painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = {
                Text(text = "Test1")
            },
            icon = { Icon(modifier = Modifier.height(48.dp), painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "") }
        )
    }
}

@Preview
@Composable
fun MainBottomBarPreview() {
    MainBottomBar()
}