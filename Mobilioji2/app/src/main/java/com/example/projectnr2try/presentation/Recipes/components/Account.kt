package com.example.projectnr2try.presentation.Recipes.components

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.projectnr2try.presentation.Recipes.RecipesViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Account(
    viewModel: RecipesViewModel = hiltViewModel()
) {
    Scaffold(
        bottomBar = { BottomBar() },
        backgroundColor = Color.Black,
        topBar = { TopBar() }
    )
    {

    }
}