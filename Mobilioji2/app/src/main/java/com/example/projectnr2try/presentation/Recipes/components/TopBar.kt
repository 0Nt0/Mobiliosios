package com.example.projectnr2try.presentation.Recipes.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun TopBar(navController: NavController) {
    TopAppBar(backgroundColor = Color.Red,
              modifier = Modifier.height(80.dp)){
        Text(
            text = "Recipe app    ",
            color= Color.White,
            fontSize = 20.sp
        )
        SearchAppBar(navController)

    }
}